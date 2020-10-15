import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Remove extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Remove(DictionaryManagement dm) {
		setTitle("Xóa từ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 200, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nh\u1EADp t\u1EEB c\u1EA7n x\u00F3a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 33, 201, 23);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(35, 74, 359, 32);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.removeWord(textField.getText());
			}
		});
		btnNewButton.setBounds(309, 200, 85, 21);
		getContentPane().add(btnNewButton);
	}

}
