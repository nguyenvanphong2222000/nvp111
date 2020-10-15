import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jFrameAdd extends JFrame {

	private JPanel contentPane;
	private JTextField word;
	private JTextField meaning;


	/**
	 * Create the frame.
	 */
	public jFrameAdd(DictionaryManagement dc) {
		setTitle("Thêm từ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 250, 400, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel1 = new JLabel("Từ cần thêm");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel1.setBounds(10, 15, 250, 20);
		contentPane.add(lblNewLabel1);

		word = new JTextField();
		word.setBounds(10, 40, 263, 19);
		contentPane.add(word);
		word.setColumns(10);
		JLabel lblNewLabel2 = new JLabel("Nghĩa của từ");
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel2.setBounds(10, 90, 250, 20);
		contentPane.add(lblNewLabel2);

		meaning = new JTextField();
		meaning.setBounds(10, 115, 263, 19);
		contentPane.add(meaning);
		meaning.setColumns(10);

		JButton buttonAdd = new JButton("Thêm từ");
		buttonAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dc.addWord(word.getText(), meaning.getText());
				JOptionPane.showMessageDialog(null, "add thanh cong");
				word.setText("");
				meaning.setText("");
			}
		});
		buttonAdd.setBounds(280, 75, 85, 21);
		contentPane.add(buttonAdd);
	}
}
