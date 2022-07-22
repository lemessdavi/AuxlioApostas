package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Casa;
import model.IDecimalFormat;
import model.UsuarioPadrao;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarBanca extends JFrame implements IDecimalFormat {

	private JPanel contentPane;
	private JTextField txtFieldQuantia;
	private JTextField textFieldNovaBanca;
	Casa casa;
	JComboBox comboBoxCasas;
	JComboBox comboBoxOperacao;
	JLabel lblNewLabel_1 = new JLabel("Banca Atual:");
	JLabel lblNewLabel = new JLabel("Quantia:");
	JButton btnAlterarBanca = new JButton("Alterar");
	UsuarioPadrao usuario;
	
	public void atualizaCasa() {
		casa = (Casa) comboBoxCasas.getSelectedItem();
	}
	
	public void atualizaBancaAtual(){
		double anterior =casa.getBanca();
		try{
			if(txtFieldQuantia.getText() == null) {
				txtFieldQuantia.setText("0");
			}
			if(comboBoxOperacao.getSelectedItem().equals("Saque")) {
				textFieldNovaBanca.setText(setDecimal(anterior - Double.parseDouble(txtFieldQuantia.getText())));
			}else {
				textFieldNovaBanca.setText(setDecimal(anterior + Double.parseDouble(txtFieldQuantia.getText())));
			}
		}catch(NullPointerException | NumberFormatException ex) {}
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		comboBoxCasas = new JComboBox(usuario.getCasas().toArray());
		comboBoxCasas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaCasa();
				atualizaBancaAtual();
				
			}
		});
		comboBoxCasas.setBounds(23, 20, 106, 27);
		contentPane.add(comboBoxCasas);
		
		
		comboBoxOperacao = new JComboBox();
		comboBoxOperacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizaCasa();
				atualizaBancaAtual();
			}
		});
		
		comboBoxOperacao.setModel(new DefaultComboBoxModel(new String[] {"Saque", "Deposito"}));
		comboBoxOperacao.setBounds(23, 59, 106, 27);
		contentPane.add(comboBoxOperacao);
		
		textFieldNovaBanca = new JTextField();
		textFieldNovaBanca.setEditable(false);
		textFieldNovaBanca.setColumns(10);
		textFieldNovaBanca.setBounds(270, 52, 130, 26);
		try {
			atualizaCasa();
			textFieldNovaBanca.setText(String.valueOf(casa.getBanca()));}
		catch (NullPointerException ex) {};
		contentPane.add(textFieldNovaBanca);
		
		
		
		txtFieldQuantia = new JTextField();
		txtFieldQuantia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				atualizaCasa();
				double anterior =casa.getBanca();
				try{
					if(txtFieldQuantia.getText().equals("")) {
						txtFieldQuantia.setText("0");
					}
					if(comboBoxOperacao.getSelectedItem().equals("Saque")) {
						textFieldNovaBanca.setText(String.valueOf(anterior - Double.parseDouble(txtFieldQuantia.getText())));
					}else {
						textFieldNovaBanca.setText(String.valueOf(anterior + Double.parseDouble(txtFieldQuantia.getText())));
					}
				}catch(NullPointerException | NumberFormatException ex) {}
			}
		});
		txtFieldQuantia.setBounds(32, 126, 130, 26);
		contentPane.add(txtFieldQuantia);
		txtFieldQuantia.setColumns(10);
		
		
		
		
		lblNewLabel.setBounds(33, 98, 61, 16);
		contentPane.add(lblNewLabel);
		
		
		
		
		lblNewLabel_1.setBounds(270, 31, 92, 16);
		contentPane.add(lblNewLabel_1);
		btnAlterarBanca.setBounds(270, 157, 117, 29);
		contentPane.add(btnAlterarBanca);
		
	}
	
	public void addActionBtnAlterarBanca(ActionListener action) {
		btnAlterarBanca.addActionListener(action);
	}
	
	public Casa getCasa() {
		return casa;
	}
	
	public String getSelectedOperation() {
		return (String) comboBoxOperacao.getSelectedItem();
	}

	public double getQuantia() {
		return Double.parseDouble(txtFieldQuantia.getText());
	}
	
	public AlterarBanca(UsuarioPadrao usuario, Home home) {
		this.usuario = usuario;
		casa = usuario.getCasas().get(0);
		initComponents();
		
		
	}
}
