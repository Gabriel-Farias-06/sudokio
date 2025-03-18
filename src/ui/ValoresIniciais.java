package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.Sudoku;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.*;

public class ValoresIniciais extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;

	public ValoresIniciais() {
		setBounds(100, 100, 600, 500);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Passe os valores do jogo da seguinte forma:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblNewLabel.setBounds(110, 24, 380, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Posição X, posição Y; valorEsperado; éFixo;");
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(110, 55, 380, 29);
			contentPanel.add(lblNewLabel_1);
		}
		
		textField = new JTextField();
		textField.setBounds(110, 95, 380, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBounds(10, 104, 397, 14);
			contentPanel.add(lblNewLabel_2);
		}
		
		JTextArea txtrJogoFcilfalse = new JTextArea();
		txtrJogoFcilfalse.setFont(new Font("Monospaced", Font.PLAIN, 11));
		txtrJogoFcilfalse.setText("Jogo fácil: 0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false 8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false 7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false 7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false 7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false 7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true 7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false 7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false 7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false");
		txtrJogoFcilfalse.setBounds(87, 129, 437, 276);
		txtrJogoFcilfalse.setLineWrap(true);
		txtrJogoFcilfalse.setWrapStyleWord(true);
		
		contentPanel.add(txtrJogoFcilfalse);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	
		                Sudoku.limparEntrada(textField.getText());
		                try {
        					Jogo frame = new Jogo();
        					frame.setVisible(true);
        				} catch (Exception ex) {
        					ex.printStackTrace();
        				}
		                dispose();
		            }
		        });
				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
