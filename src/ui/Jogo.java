package ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;

public class Jogo extends JFrame {

	private JPanel contentPane;

	public Jogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 9, 5, 5));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(78, 22, 297, 170);
		contentPane.add(panel);
		
		for(int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
			    JLabel lblNewLabel = new JLabel("0", SwingConstants.CENTER);
			    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			    lblNewLabel.setForeground(new Color(255, 255, 255));
			    panel.add(lblNewLabel);
			}
		}
		
		
	}
}
