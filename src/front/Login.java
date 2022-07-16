package front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import banco.BD;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import back.Admin;
import back.IDecimalFormat;
import back.Usuario;
import back.UsuarioPadrao;

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
	Usuario usuarioLogado;
	
	private boolean autenticaUsuario() {
		String login = txtFieldNome.getText();
		String senha = txtFieldSenha.getText();
	
		System.out.println("Login" + login + senha);
		
		for (Usuario usuario : BD.getUsuarios()) {
			System.out.println("DENTRO" +usuario.getLogin() + usuario.getSenha());
			if(login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha())) {
				usuarioLogado = usuario;
				return true;
			}
		}
		return false;
	}
	
	
	public void addRowToJTabel() {
		DefaultTableModel model =  (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		ArrayList<UsuarioPadrao> listaUsuarios = (ArrayList<UsuarioPadrao>) BD.getUsuariosPadrao();
		Object rowData[] = new Object[2];
		for (UsuarioPadrao usuario : listaUsuarios) {
			
			rowData[0] = usuario.getLogin();
			rowData[1] = setDecimal(usuario.getBancaTotal());
			model.addRow(rowData);
		}
	}
	
	
	
	public Login() {
		Login login= this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(25, 44, 61, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
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
		
		JLabel lblOu = new JLabel("ou");
		lblOu.setBounds(210, 229, 61, 16);
		contentPane.add(lblOu);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroUsuario telaCadastro = new CadastroUsuario(login);
				telaCadastro.setVisible(true);
			}
		});
		btnCadastrar.setBounds(307, 224, 117, 29);
		contentPane.add(btnCadastrar);
		
		// verifia usuario
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(autenticaUsuario());
				if (autenticaUsuario()) {
					if(usuarioLogado.getClass() == Admin.class) {
						HomeAdmin home = new HomeAdmin(((Admin) usuarioLogado));
						home.setVisible(true);
						dispose();
					}else {
						Home home = new Home(usuarioLogado);
						home.setVisible(true);
						dispose();
					}
				}else {

					TelaErro telaErro = new TelaErro("Dados Incorretos");
					telaErro.setVisible(true);
				}
				
				
			}
		});
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
		
		JLabel lblUsuariosCadastrados = new JLabel("Usuarios Cadastrados:");
		lblUsuariosCadastrados.setBounds(264, 44, 146, 16);
		contentPane.add(lblUsuariosCadastrados);
	}
}
