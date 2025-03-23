package src.ui;

import javax.swing.*;
import javax.swing.border.*;

import src.service.Cordenadas;
import src.service.Sudoku;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.Font;

public class Jogo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Map<Cordenadas, JTextField> textFields = new HashMap<>();

	public Jogo(Map<Cordenadas, Integer> valores) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 9, 5, 5));
		panel.setBounds(63, 11, 360, 360);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Status do jogo: Em andamento");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(116, 382, 255, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Finalizar Jogo");
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setBounds(119, 417, 120, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        if(Sudoku.verificarStatus()) lblNewLabel.setText("Status do jogo: Concluído");
                        }
                });
            }
        });
		
		JButton btnNovoJogo = new JButton("Novo jogo");
		btnNovoJogo.setForeground(new Color(255, 0, 0));
		btnNovoJogo.setBounds(248, 417, 110, 30);
		contentPane.add(btnNovoJogo);
		
		btnNovoJogo.addActionListener(new ActionListener() {
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
		
		valores.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(valor -> {
			if (valor.getKey().isFixo()) {
				textField = new JTextField(valor.getValue() + "", 2);
				textField.setEditable(false);
				int coluna = valor.getKey().getCordenadas(0);
				int linha = valor.getKey().getCordenadas(1);
				if(coluna % 3 == 0 && coluna != 0) textField.setBorder(BorderFactory.createCompoundBorder(
					    new MatteBorder(0, 3, 0, 0, Color.RED),
					    new EmptyBorder(0, 3, 0, 0)
					));
				if(linha % 3 == 0 && linha != 0) textField.setBorder(BorderFactory.createCompoundBorder(
					    new MatteBorder(3, 0, 0, 0, Color.RED),
					    new EmptyBorder(3, 0, 0, 0)
					));
				if(linha % 3 == 0 && linha != 0 && coluna % 3 == 0 && coluna != 0) textField.setBorder(BorderFactory.createCompoundBorder(
					    new MatteBorder(3, 3, 0, 0, Color.RED),
					    new EmptyBorder(3, 3, 0, 0)
				   ));	
				
			} else {
				textField = new JTextField("", 2);
				int coluna = valor.getKey().getCordenadas(0);
				int linha = valor.getKey().getCordenadas(1);
				if(coluna % 3 == 0 && coluna != 0) textField.setBorder(BorderFactory.createCompoundBorder(
					    new MatteBorder(0, 3, 0, 0, Color.RED),
					    new EmptyBorder(0, 3, 0, 0)
					));
				if(linha % 3 == 0 && linha != 0) textField.setBorder(BorderFactory.createCompoundBorder(
					    new MatteBorder(3, 0, 0, 0, Color.RED),
					    new EmptyBorder(3, 0, 0, 0)
					));
				if(linha % 3 == 0 && linha != 0 && coluna % 3 == 0 && coluna != 0) textField.setBorder(BorderFactory.createCompoundBorder(
					    new MatteBorder(3, 3, 0, 0, Color.RED),
					    new EmptyBorder(3, 3, 0, 0)
				   ));	
			}
			
			textField.setHorizontalAlignment(JTextField.CENTER);
			textFields.put(valor.getKey(),textField);
			panel.add(textField);
		});
		
		textFields.entrySet().stream().forEach(campo -> {
			if(!campo.getKey().isFixo())
				campo.getValue().addFocusListener(new FocusAdapter() {
					@Override
					public void focusLost(FocusEvent e) {
					if(!campo.getValue().getText().isEmpty())	
					      SwingUtilities.invokeLater(() -> {
					            try {
									Sudoku.adicionarValor(campo.getKey(),Integer.parseInt(campo.getValue().getText()));
								} catch (NumberFormatException e1) {
									e1.printStackTrace();
								} catch (Exception e1) {
									e1.printStackTrace();
								}
					      });
					}
				});
		});
		
		panel.revalidate();
		panel.repaint();
	}
}
