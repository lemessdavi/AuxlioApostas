package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import model.Admin;
import model.IDecimalFormat;
import model.Usuario;
import model.UsuarioPadrao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements IDecimalFormat {

	private JPanel contentPane;
	private JTextField txtFieldNome;
	private JTextField txtFieldSenha;
	private JTable table;
	private Usuario usuarioLogado;
	private JButton btnCadastrar = new JButton("Cadastrar");
	private JLabel lblNewLabel = new JLabel("Login");
	private JLabel lblSenha = new JLabel("Senha");
	private JLabel lblOu = new JLabel("ou");
	private JButton btnLogin = new JButton("Login");
	private JLabel lblUsuariosCadastrados = new JLabel("Usuarios Cadastrados:");
	
	public boolean autenticaUsuario() {
		String login = txtFieldNome.getText();
		String senha = txtFieldSenha.getText();
	
		System.out.println("Login" + login + senha);
		
		for (Usuario usuario : DAO.getUsuarios()) {
			System.out.println("DENTRO" +usuario.getLogin() + usuario.getSenha());
			if(login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
				usuarioLogado = usuario;
				System.out.println(usuario.getLogin());
				return true;
			}
		}
		return false;
	}
	
	public Usuario getUsuarioLogado() {
		System.out.println(usuarioLogado.getLogin());
		return usuarioLogado;
	}
	
	
	public void addRowToJTabel() {
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<UsuarioPadrao> listaUsuarios = (ArrayList<UsuarioPadrao>) DAO.getUsuariosPadrao();
		Object rowData[] = new Object[2];
		for (UsuarioPadrao usuario : listaUsuarios) {
			
			rowData[0] = usuario.getLogin();
			rowData[1] = setDecimal(usuario.getBancaTotal());
			model.addRow(rowData);
		}
	}
	
	private void initComponentes(){

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel.setBounds(25, 44, 61, 16);
		contentPane.add(lblNewLabel);
		
		
		lblSenha.setBounds(25, 127, 61, 16);
		contentPane.add(lblSenha);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(25, 69, 152, 36);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		txtFieldSenha = new JTextField();
		txtFieldSenha.setColumns(10);
		txtFieldSenha.setBounds(25, 145, 152, 36);
		contentPane.add(txtFieldSenha);
		
		
		lblOu.setBounds(210, 229, 61, 16);
		contentPane.add(lblOu);
		
		
		btnCadastrar.setBounds(307, 224, 117, 29);
		contentPane.add(btnCadastrar);
		

		btnLogin.setBounds(38, 224, 117, 29);
		contentPane.add(btnLogin);
		
		table = new JTable(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Login", "Banca"
	            }
	        ));
		table.setBounds(252, 69, 169, 120);
		addRowToJTabel();
		contentPane.add(table);
		
		
		lblUsuariosCadastrados.setBounds(264, 44, 146, 16);
		contentPane.add(lblUsuariosCadastrados);
		
	}
	
	public void addActionBtnCadastrar(ActionListener action) {
		btnCadastrar.addActionListener(action);
	}
	
	public void addActionBtnLogin(ActionListener action) {
		btnLogin.addActionListener(action);
	}
	public Login() {
		initComponentes();
	}
}
