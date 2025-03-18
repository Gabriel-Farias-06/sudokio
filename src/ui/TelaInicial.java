package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

public class TelaInicial extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaInicial() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20)); 
        
        JLabel lblNewLabel = new JLabel("Bem-vindo ao Sudokio");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("O que deseja fazer?");
        contentPane.add(lblNewLabel_1);
        
        JButton btnIniciar = new JButton("Iniciar Novo Jogo");
        btnIniciar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnIniciar.setBorder(new LineBorder(new Color(128, 128, 128), 2, true));
        btnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            ValoresIniciais frame = new ValoresIniciais();
                            frame.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        btnIniciar.setPreferredSize(new Dimension(200, 35));  
        contentPane.add(btnIniciar);
        
        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        btnSair.setForeground(new Color(220, 20, 60));
        btnSair.setBorder(new LineBorder(new Color(220, 20, 60), 2, true));
        btnSair.setPreferredSize(new Dimension(200, 35)); 
        contentPane.add(btnSair);
    }
}
