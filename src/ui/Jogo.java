package ui;

import javax.swing.*;
import javax.swing.border.*;

import service.Cordenadas;
import service.Sudoku;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jogo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Map<Cordenadas, JTextField> textFields = new HashMap<>();

	public Jogo(Map<Cordenadas, Integer> valores) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9, 9, 5, 5));
		panel.setBounds(33, 11, 360, 360);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		
		valores.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(valor -> {
			if (valor.getKey().isFixo()) {
				textField = new JTextField(valor.getValue() + "", 2);
				textField.setEditable(false);
			} else {
				textField = new JTextField("", 2);
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
