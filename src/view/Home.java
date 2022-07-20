package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.DAO;
import model.Admin;
import model.Casa;
import model.IDecimalFormat;
import model.Usuario;
import model.UsuarioPadrao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Home extends JFrame implements IDecimalFormat {

	private JPanel contentPane;
	private JTable tableCasasBancas;
	private Usuario usuario;
	private JTextField textFieldLucro;
	JLabel lblNewLabel;
	JLabel lblCasas;
	JLabel lblAdicionarBet;
	JLabel lblAlterarBanca;
	JButton btnAddBet;
	JButton btnAlterar;
	JButton btnAdicionarCasa;
	JLabel lblAdicionarCasa;


	
	
	public void addRowToJTabel() {
		DefaultTableModel model =  (DefaultTableModel) tableCasasBancas.getModel();
		model.setRowCount(0);
		if(usuario.getClass() == UsuarioPadrao.class)  {
		ArrayList<Casa> listaCasas = (ArrayList<Casa>) ((UsuarioPadrao) usuario).getCasas();
		Object rowData[] = new Object[2];
		for (Casa casa : listaCasas) {
			
			rowData[0] = casa.getNome();
			rowData[1] = setDecimal(casa.getBanca());
			model.addRow(rowData);
		}
		} else {
			ArrayList<UsuarioPadrao> listaUsuarios = (ArrayList<UsuarioPadrao>) DAO.getUsuariosPadrao();
			Object rowData[] = new Object[2];
			for (UsuarioPadrao usuario : listaUsuarios) {
				
				rowData[0] = usuario.getLogin();
				rowData[1] = usuario.getBancaTotal();
				model.addRow(rowData);
			}
			
			
		}
	}
	
	public JTable getTableCasasBancas() {
		return tableCasasBancas;
	}
	
	public JTextField getTextFieldLucro() {
		return textFieldLucro;
	}
	
	
	public Home(Usuario usuario) {
		this.usuario = usuario;
		Home home = this;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Lucro");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(81, 29, 44, 16);
		contentPane.add(lblNewLabel);
		
		
		lblCasas = new JLabel("Casas:");
		lblCasas.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblCasas.setBounds(37, 106, 118, 16);
		contentPane.add(lblCasas);
		
		 tableCasasBancas = new JTable(new javax.swing.table.DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Nome", "Banca"
	            }
	        ));
		addRowToJTabel();
		tableCasasBancas.setBounds(37, 134, 144, 113);
		contentPane.add(tableCasasBancas);
		
		lblAdicionarBet = new JLabel("Adicionar Bet:");
		lblAdicionarBet.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAdicionarBet.setBounds(293, 29, 118, 16);
		contentPane.add(lblAdicionarBet);
		
		lblAlterarBanca = new JLabel("Alterar Banca:");
		lblAlterarBanca.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAlterarBanca.setBounds(293, 107, 118, 16);
		contentPane.add(lblAlterarBanca);
		
		btnAddBet = new JButton("Adicionar");
		btnAddBet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarBet addBetTela = new AdicionarBet((UsuarioPadrao)usuario, home);
				addBetTela.setVisible(true);
			}
		});
		btnAddBet.setBounds(294, 57, 117, 29);
		contentPane.add(btnAddBet);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarBanca telaAlterarBanca = new AlterarBanca((UsuarioPadrao) usuario, home);
				telaAlterarBanca.setVisible(true);
			}
		});
		btnAlterar.setBounds(293, 139, 117, 29);
		contentPane.add(btnAlterar);
		
		lblAdicionarCasa = new JLabel("Adicionar Casa:");
		lblAdicionarCasa.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblAdicionarCasa.setBounds(293, 190, 129, 16);
		contentPane.add(lblAdicionarCasa);
		
		btnAdicionarCasa = new JButton("Adicionar");
		btnAdicionarCasa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarCasa telaAddCasa = new AdicionarCasa((UsuarioPadrao) usuario, home);
				telaAddCasa.setVisible(true);
			}
		});
		btnAdicionarCasa.setBounds(293, 218, 117, 29);
		contentPane.add(btnAdicionarCasa);
		
		textFieldLucro = new JTextField();
		textFieldLucro.setEditable(false);
		textFieldLucro.setBounds(37, 47, 144, 35);
		contentPane.add(textFieldLucro);
		textFieldLucro.setColumns(10);
		
		try {
		textFieldLucro.setText(setDecimal(((UsuarioPadrao) usuario).getLucroTotal()));
		} catch (ClassCastException ex) {}
		
	}
	

}
