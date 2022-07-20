package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Admin;
import model.Casa;
import model.Usuario;
import model.UsuarioPadrao;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtFieldNome;
	private JTextField txtFieldSenha;
	private JTextField txtFieldNomeCasa;
	private JTextField txtFieldBanca;
	JLabel lblNewLabel = new JLabel("Nome");
	JLabel lblSenha = new JLabel("Senha");
	JButton btnCadastrarUsuario = new JButton("Cadastrar");
	JLabel lblNewLabel_1 = new JLabel("Dados da Casa:");
	JLabel lblNewLabel_1_1 = new JLabel("Dados do Usuario:");
	JLabel lblNewLabel_2 = new JLabel("Nome");
	JLabel lblBanca = new JLabel("Banca");
	JCheckBox chckbxAdministrador = new JCheckBox("Administrador?");
	
	public void exibirAdm(boolean x) {
		lblNewLabel_1.setVisible(x);
		lblNewLabel_2.setVisible(x);
		lblBanca.setVisible(x);
		txtFieldNomeCasa.setVisible(x);
		txtFieldBanca.setVisible(x);
	}
	
	private void initComponents(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblNewLabel.setBounds(45, 49, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(45, 64, 130, 26);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		
		lblSenha.setBounds(45, 128, 61, 16);
		contentPane.add(lblSenha);
		
		txtFieldSenha = new JTextField();
		txtFieldSenha.setColumns(10);
		txtFieldSenha.setBounds(45, 140, 130, 26);
		contentPane.add(txtFieldSenha);
		
		
		
		
		btnCadastrarUsuario.setBounds(164, 213, 117, 29);
		contentPane.add(btnCadastrarUsuario);
		
		
		lblNewLabel_1.setBounds(263, 16, 175, 16);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_1_1.setBounds(41, 16, 175, 16);
		contentPane.add(lblNewLabel_1_1);
		
		
		lblNewLabel_2.setBounds(263, 49, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		txtFieldNomeCasa = new JTextField();
		txtFieldNomeCasa.setColumns(10);
		txtFieldNomeCasa.setBounds(263, 64, 130, 26);
		contentPane.add(txtFieldNomeCasa);
		
		
		lblBanca.setBounds(263, 125, 61, 16);
		contentPane.add(lblBanca);
		
		txtFieldBanca = new JTextField();
		txtFieldBanca.setColumns(10);
		txtFieldBanca.setBounds(263, 140, 130, 26);
		contentPane.add(txtFieldBanca);
		
		
		chckbxAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAdministrador.isSelected()) {
					exibirAdm(false);
				}else {
					exibirAdm(true);
				}
			}
		});
		chckbxAdministrador.setBounds(47, 178, 128, 23);
		contentPane.add(chckbxAdministrador);
		
	}
	
	public void addActionBtnCadastrarUsuario(ActionListener action){
		btnCadastrarUsuario.addActionListener(action);
	}
	
	public boolean isAdm() {
		return chckbxAdministrador.isSelected();
	}
	public String getNome() {
		return txtFieldNome.getText();
	}
	
	public String getSenha() {
		return txtFieldSenha.getText();
	}
	public Double getBanca() {
		return Double.parseDouble(txtFieldBanca.getText());
	}
	public String getNomeCasa() {
		return txtFieldNomeCasa.getText();
	}
	
	public CadastroUsuario(Login login) {
		initComponents();
	}
}
