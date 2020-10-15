import java.awt.*;

import com.darkprograms.speech.translator.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Translate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Translate(DictionaryManagement dm ) {
		setTitle("Dịch câu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(280, 180, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tiếng Anh");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(41, 18, 120, 24);
		contentPane.add(lblNewLabel);
		
		JTextArea TextPage = new JTextArea();
		TextPage.setBounds(41, 44, 401, 139);
		contentPane.add(TextPage);
		
		JButton btnNewButton = new JButton("Dịch");
		
		btnNewButton.setBounds(465, 159, 100, 21);
		contentPane.add(btnNewButton);
		JLabel lblNewLabel1 = new JLabel("Tiếng Việt");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel1.setBounds(41, 202, 120, 24);
		contentPane.add(lblNewLabel1);
		JTextArea textTranslate = new JTextArea();
		textTranslate.setBounds(41, 227, 401, 150);
		contentPane.add(textTranslate);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textTranslate.setText(GoogleTranslate.translate("en", "vi", TextPage.getText()));
				} catch (IOException evt) {
					
				}
			}
		});
	}
}
