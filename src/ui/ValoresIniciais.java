package src.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import src.service.Sudoku;
import src.service.Niveis;


public class ValoresIniciais extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public ValoresIniciais() {
		setBounds(100, 100, 372, 225);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Selecione o nível de dificuldade do jogo:");
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			lblNewLabel.setBounds(32, 21, 300, 29);
			contentPanel.add(lblNewLabel);
		}
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(" Fácil");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(32, 57, 109, 23);
		contentPanel.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMdio = new JRadioButton(" Médio");
		rdbtnMdio.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnMdio.setBounds(32, 81, 109, 23);
		contentPanel.add(rdbtnMdio);
		
		JRadioButton rdbtnFcil = new JRadioButton(" Difícil");
		rdbtnFcil.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnFcil.setBounds(32, 105, 109, 23);
		contentPanel.add(rdbtnFcil);
		
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rdbtnNewRadioButton);
        grupo.add(rdbtnMdio);
        grupo.add(rdbtnFcil);

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
		            	
		                if(rdbtnNewRadioButton.isSelected()) Sudoku.limparEntrada(Niveis.FACIL.getNivel());
		                else if(rdbtnMdio.isSelected()) Sudoku.limparEntrada(Niveis.MEDIO.getNivel());
		                else if(rdbtnFcil.isSelected()) Sudoku.limparEntrada(Niveis.DIFICIL.getNivel());
		                else return;
		                dispose();
		            }
		        });
				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
                            @Override
							public void run() {
								TelaInicial frame = new TelaInicial();
								frame.setVisible(true);
								dispose();
							}
						});   
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
}
