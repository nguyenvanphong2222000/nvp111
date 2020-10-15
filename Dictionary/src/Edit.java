import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edit extends JFrame {

	private JPanel contentPane;
	private JTextField textWord;
	private JTextField textMean;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Edit(DictionaryManagement dm) {
		setTitle("Sửa từ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 250, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textWord = new JTextField();
		textWord.setBounds(10, 40, 250, 20);
		contentPane.add(textWord);
		textWord.setColumns(10);

		JLabel lblNewLabel = new JLabel("Từ cần sửa");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 15, 250, 20);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dm.edit(textWord.getText(), textMean.getText());
			}
		});
		btnNewButton.setBounds(200, 170, 80, 25);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Nghĩa của từ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 100, 250, 20);
		contentPane.add(lblNewLabel_1);

		textMean = new JTextField();
		textMean.setBounds(10, 125,250 , 20);
		contentPane.add(textMean);
		textMean.setColumns(10);
	}
}
