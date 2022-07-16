package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import banco.BD;
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
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CadastroUsuario(Login login) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(45, 49, 61, 16);
		contentPane.add(lblNewLabel);
		
		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(45, 64, 130, 26);
		contentPane.add(txtFieldNome);
		txtFieldNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(45, 128, 61, 16);
		contentPane.add(lblSenha);
		
		txtFieldSenha = new JTextField();
		txtFieldSenha.setColumns(10);
		txtFieldSenha.setBounds(45, 140, 130, 26);
		contentPane.add(txtFieldSenha);
		
		
		
		JButton btnCadastrarUsuario = new JButton("Cadastrar");
		btnCadastrarUsuario.setBounds(164, 213, 117, 29);
		contentPane.add(btnCadastrarUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("Dados da Casa:");
		lblNewLabel_1.setBounds(263, 16, 175, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Dados do Usuario:");
		lblNewLabel_1_1.setBounds(41, 16, 175, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setBounds(263, 49, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		txtFieldNomeCasa = new JTextField();
		txtFieldNomeCasa.setColumns(10);
		txtFieldNomeCasa.setBounds(263, 64, 130, 26);
		contentPane.add(txtFieldNomeCasa);
		
		JLabel lblBanca = new JLabel("Banca");
		lblBanca.setBounds(263, 125, 61, 16);
		contentPane.add(lblBanca);
		
		txtFieldBanca = new JTextField();
		txtFieldBanca.setColumns(10);
		txtFieldBanca.setBounds(263, 140, 130, 26);
		contentPane.add(txtFieldBanca);
		
		JCheckBox chckbxAdministrador = new JCheckBox("Administrador?");
		chckbxAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxAdministrador.isSelected()) {
					lblNewLabel_1.setVisible(false);
					lblNewLabel_2.setVisible(false);
					lblBanca.setVisible(false);
					txtFieldNomeCasa.setVisible(false);
					txtFieldBanca.setVisible(false);
					
				}else {
					lblNewLabel_1.setVisible(true);
					lblNewLabel_2.setVisible(true);
					lblBanca.setVisible(true);
					txtFieldNomeCasa.setVisible(true);
					txtFieldBanca.setVisible(true);
				}
			}
		});
		chckbxAdministrador.setBounds(47, 178, 128, 23);
		contentPane.add(chckbxAdministrador);
		
		
		btnCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario;
				if (chckbxAdministrador.isSelected()) {
					usuario = new Admin(txtFieldNome.getText(), txtFieldSenha.getText());
					dispose();
				} else {
					try {
						double banca = Double.parseDouble(txtFieldBanca.getText());
						Casa casa = new Casa(txtFieldNomeCasa.getText(),banca);
						usuario = new UsuarioPadrao(txtFieldNome.getText(), txtFieldSenha.getText(), casa );
						login.addRowToJTabel();
						dispose();
					} catch (NumberFormatException ex) {
						TelaErro telaErro = new TelaErro("Insira Apenas Números");
						telaErro.setVisible(true);
					}
					
				}
				
			}
		});
		
		
	}
}
