package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Casa;
import model.UsuarioPadrao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarCasa extends JFrame {

	private JPanel contentPane;
	private JTextField txtField_Casa;
	private JTextField txtField_Banca;

	/**
	 * Create the frame.
	 */
	public AdicionarCasa(UsuarioPadrao usuario, Home home) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da Casa:");
		lblNewLabel.setBounds(20, 19, 117, 16);
		contentPane.add(lblNewLabel);
		
		txtField_Casa = new JTextField();
		txtField_Casa.setBounds(21, 38, 130, 26);
		contentPane.add(txtField_Casa);
		txtField_Casa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Banca:");
		lblNewLabel_1.setBounds(20, 111, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtField_Banca = new JTextField();
		txtField_Banca.setColumns(10);
		txtField_Banca.setBounds(20, 128, 130, 26);
		contentPane.add(txtField_Banca);
		
		JButton btnAdcionarCasa = new JButton("Adiconar Casa");
		btnAdcionarCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario.addCasa(new Casa(txtField_Casa.getText(), Double.parseDouble(txtField_Banca.getText()))); 
				home.addRowToJTabel();
				dispose();
			}
		});
		btnAdcionarCasa.setBounds(199, 85, 117, 29);
		contentPane.add(btnAdcionarCasa);
	}
}
