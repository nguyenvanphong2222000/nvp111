import java.awt.BorderLayout;
import java.awt.EventQueue;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class DictionaryApplication extends JFrame {
	DictionaryManagement dm = new DictionaryManagement();
	private JPanel contentPane;
	private JTextField inputWord;
	private javax.swing.JLabel jLabel1;
	Translate translate = new Translate(dm);
	Edit edit = new Edit(dm);
	Remove remove = new Remove(dm);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DictionaryApplication frame = new DictionaryApplication();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DictionaryApplication() {
		dm.insertFromFile();
		jFrameAdd jadd = new jFrameAdd(dm);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new java.awt.Color(51, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		jLabel1 = new javax.swing.JLabel();
		jLabel1.setBounds(0, 0, 137, 81);
		contentPane.add(jLabel1);
		jLabel1.setIcon(new javax.swing.ImageIcon("Digo.PNG")); // NOI18N

		inputWord = new JTextField();
		inputWord.setBounds(224, 45, 200, 25);
		contentPane.add(inputWord);
		inputWord.setColumns(10);

		JList list = new JList();
		list.setBounds(150, 90, 274, 300);
		list.setBackground(Color.WHITE);
		contentPane.add(list);

		JTextArea out = new JTextArea();
		out.setBounds(434, 90, 307, 268);
		out.setBackground(Color.WHITE);
		contentPane.add(out);

		JButton addButton = new JButton("Thêm từ");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jadd.setVisible(true);
			}
		});
		addButton.setBounds(10, 100, 125, 40);
		addButton.setBackground(new java.awt.Color(51, 153, 255));
		addButton.setForeground(new java.awt.Color(255, 255, 255));
		addButton.setIcon(new javax.swing.ImageIcon("Them_tu.PNG"));
		addButton.setBorderPainted(false);
		contentPane.add(addButton);
		JButton editButton = new JButton("Sửa từ");
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit.setVisible(true);
			}
		});


		editButton.setBounds(10, 147, 125, 40);
		contentPane.add(editButton);
		editButton.setBorderPainted(false);
		editButton.setBackground(new java.awt.Color(51, 153, 255));
		editButton.setForeground(new java.awt.Color(255, 255, 255));
		editButton.setIcon(new javax.swing.ImageIcon("Sua_tu.PNG"));
		JButton btnNewButton_2 = new JButton("Xóa từ");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(10, 192, 125, 40);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.setBackground(new java.awt.Color(51, 153, 255));
		btnNewButton_2.setForeground(new java.awt.Color(255, 255, 255));
		btnNewButton_2.setIcon(new javax.swing.ImageIcon("Xoa_tu.PNG"));
		btnNewButton_2.setBorderPainted(false);

		JButton buttontts = new JButton("");
		buttontts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
				Voice voice;
				voice = VoiceManager.getInstance().getVoice("kevin16");
				if(voice != null) {
					voice.allocate();
					voice.speak(inputWord.getText());
				}

			}
		});
		buttontts.setBounds(434, 358, 30, 30);
		contentPane.add(buttontts);
		buttontts.setBackground(new java.awt.Color(51, 153, 255));
		buttontts.setForeground(new java.awt.Color(255, 255, 255));
		buttontts.setIcon(new javax.swing.ImageIcon("Loa.PNG"));
		buttontts.setBorderPainted(false);
		JButton translateButton = new JButton("Dịch câu");
		translateButton.setBounds(10, 237, 120, 40);
		contentPane.add(translateButton);
		translateButton.setBackground(new java.awt.Color(51, 153, 255));
		translateButton.setForeground(new java.awt.Color(255, 255, 255));
		translateButton.setBorderPainted(false);
		translateButton.setIcon(new javax.swing.ImageIcon("Dich_cau.PNG"));
		translateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				translate.setVisible(true);
			}
		});
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(382, 51, -181, 186);
		contentPane.add(textArea_2);
		
		JButton buttonTrans = new JButton("Tra Từ");
		buttonTrans.setBounds(434, 45,80 , 25);
		buttonTrans.setBackground(new java.awt.Color(255, 153, 153));
		buttonTrans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.setText(dm.dictionaryLookup(inputWord.getText()));
			}
		});
		contentPane.add(buttonTrans);
		buttonTrans.setBorderPainted(false);
		inputWord.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				DefaultListModel model = new DefaultListModel();
				LinkedList<String> temp = new LinkedList<String>();
				String text = inputWord.getText();
				if((int)e.getKeyChar() == 8 && text.length() >=1) {
					text = text.substring(0,text.length());
				} else {
					text += e.getKeyChar();
				}
				temp = dm.dictionarySearcher(text);
				for (String s:temp) {
					model.addElement(s);
				}
				list.setModel(model);
			}
		});
	}
}
