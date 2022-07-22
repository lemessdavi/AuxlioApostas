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
	JLabel lblNewLabel = new JLabel("Nome da Casa:");
	JLabel lblNewLabel_1 = new JLabel("Banca:");
	JButton btnAdcionarCasa = new JButton("Adiconar Casa");
	
	private void initComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		lblNewLabel.setBounds(20, 19, 117, 16);
		contentPane.add(lblNewLabel);
		
		txtField_Casa = new JTextField();
		txtField_Casa.setBounds(21, 38, 130, 26);
		contentPane.add(txtField_Casa);
		txtField_Casa.setColumns(10);
		
		
		lblNewLabel_1.setBounds(20, 111, 61, 16);
		contentPane.add(lblNewLabel_1);
		
		txtField_Banca = new JTextField();
		txtField_Banca.setColumns(10);
		txtField_Banca.setBounds(20, 128, 130, 26);
		contentPane.add(txtField_Banca);
		
		btnAdcionarCasa.setBounds(199, 85, 117, 29);
		contentPane.add(btnAdcionarCasa);
		
	}
	
	public void addActionBtnAddCasa(ActionListener action) {
		btnAdcionarCasa.addActionListener(action);
	}
	
	public String getNomeCasa() {
		return txtField_Casa.getText();
	}
	
	public double getBanca() {
		return Double.parseDouble(txtField_Banca.getText());
	}
	
	public AdicionarCasa(UsuarioPadrao usuario, Home home) {
		
		initComponentes();
		
	}
}
