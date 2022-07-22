package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAO;
import model.Bet;
import model.Casa;
import model.IDecimalFormat;
import model.Usuario;
import model.UsuarioPadrao;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class AdicionarBet extends JFrame implements IDecimalFormat{

	private JPanel contentPane;
	private JTextField txtFieldLucro;
	private JTextField txtFieldStake;
	private JTextField txtFieldOdd;
	private JTextField txtFieldStakeWinWin;
	private JTextField txtFieldOddWinWin;
	private JComboBox comboBoxCasaWinWin;
	private JComboBox comboBoxCasa ;
	private JCheckBox chckbxGreen;
	private JCheckBox chckbxWinWin;
	private JCheckBox chckbxGreenWinWin;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1_2;
	private JLabel lblNewLabel_1_1_1_1;
	private Usuario usuario;
	private double lucro;
	private JLabel lblNewLabel_1_1 = new JLabel("Stake");
	private JLabel lblNewLabel_1_1_1 = new JLabel("Odd @");
	JButton btnCadastrarBet = new JButton("Cadastrar Bet");

	private double calculaLucro(boolean green, double stake, double odd) {
		if (green)
			return (stake * odd) - stake;
		return - stake;
	}
	
	public void showWinWin(boolean x) {
		comboBoxCasaWinWin.setVisible(x);
		chckbxGreenWinWin.setVisible(x);
		txtFieldOddWinWin.setVisible(x);
		lblNewLabel_1_1_1_1.setVisible(x);
		txtFieldStakeWinWin.setVisible(x);
		lblNewLabel_1_1_2.setVisible(x);
		lblNewLabel_2.setVisible(x);
	}
	
	
	private double calculaWinWin(boolean green, double stake, double odd, boolean green2, double stake2, double odd2) {
		return calculaLucro(green, stake, odd) + calculaLucro(green2, stake2, odd2) ;
	}

	public void atualizaLucro() {
		
		try {
		if(!chckbxWinWin.isSelected()) {
			lucro = calculaLucro(chckbxGreen.isSelected(), Double.parseDouble(txtFieldStake.getText()), Double.parseDouble(txtFieldOdd.getText()));
			txtFieldLucro.setText(setDecimal(lucro));
			
		} else {
			lucro = calculaWinWin(chckbxGreen.isSelected(), Double.parseDouble(txtFieldStake.getText()), Double.parseDouble(txtFieldOdd.getText()),
						          chckbxGreenWinWin.isSelected(), Double.parseDouble(txtFieldStakeWinWin.getText()), Double.parseDouble(txtFieldOddWinWin.getText()));
			txtFieldLucro.setText(setDecimal(lucro));
		}
		}catch(java.lang.NumberFormatException ex) {
			
			//cria tela de erro e mostra
			 System.out.println("erro");
		}
		
	}
	
	private void initComponentes() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
	
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Casa");
		lblNewLabel.setBounds(31, 17, 61, 16);
		contentPane.add(lblNewLabel);
		
		comboBoxCasa = new JComboBox(((UsuarioPadrao) usuario).getCasas().toArray());
		comboBoxCasa.setBounds(68, 13, 128, 27);
	
		contentPane.add(comboBoxCasa);
		
		JLabel lblNewLabel_1 = new JLabel("Lucro");
		lblNewLabel_1.setBounds(262, 220, 41, 16);
		contentPane.add(lblNewLabel_1);
		
		txtFieldLucro = new JTextField();
		txtFieldLucro.setEditable(false);
		txtFieldLucro.setBounds(309, 215, 102, 26);
		contentPane.add(txtFieldLucro);
		txtFieldLucro.setColumns(10);
		
		txtFieldStake = new JTextField();
		txtFieldStake.setColumns(10);
		txtFieldStake.setBounds(84, 65, 112, 26);
		contentPane.add(txtFieldStake);
		
		lblNewLabel_1_1.setBounds(31, 70, 41, 16);
		contentPane.add(lblNewLabel_1_1);
		
		
		lblNewLabel_1_1_1.setBounds(31, 108, 41, 16);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtFieldOdd = new JTextField();
		txtFieldOdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				atualizaLucro();
			}
		});
		txtFieldOdd.setColumns(10);
		txtFieldOdd.setBounds(84, 103, 112, 26);
		contentPane.add(txtFieldOdd);
		
		 chckbxGreen = new JCheckBox("Green?");
		 chckbxGreen.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		atualizaLucro();
		 	}
		 });
		chckbxGreen.setBounds(31, 146, 79, 23);
		contentPane.add(chckbxGreen);
		

		
		//win win
		lblNewLabel_2 = new JLabel("Casa");
		lblNewLabel_2.setBounds(262, 17, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		comboBoxCasaWinWin = new JComboBox(((UsuarioPadrao) usuario).getCasas().toArray());
		comboBoxCasaWinWin.setBounds(299, 13, 128, 27);
		contentPane.add(comboBoxCasaWinWin);
		
		lblNewLabel_1_1_2 = new JLabel("Stake");
		lblNewLabel_1_1_2.setBounds(262, 70, 41, 16);
		contentPane.add(lblNewLabel_1_1_2);
		
		txtFieldStakeWinWin = new JTextField();
		txtFieldStakeWinWin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				atualizaLucro();
			}
		});
		txtFieldStakeWinWin.setColumns(10);
		txtFieldStakeWinWin.setBounds(315, 65, 112, 26);
		contentPane.add(txtFieldStakeWinWin);
		
		lblNewLabel_1_1_1_1 = new JLabel("Odd @");
		lblNewLabel_1_1_1_1.setBounds(262, 108, 41, 16);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		txtFieldOddWinWin = new JTextField();
		txtFieldOddWinWin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				atualizaLucro();
			}
		});
		txtFieldOddWinWin.setColumns(10);
		txtFieldOddWinWin.setBounds(315, 103, 112, 26);
		contentPane.add(txtFieldOddWinWin);
		
		 chckbxGreenWinWin = new JCheckBox("Green?");
		 chckbxGreenWinWin.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		atualizaLucro();
		 	}
		 });
		chckbxGreenWinWin.setBounds(262, 146, 79, 23);
		contentPane.add(chckbxGreenWinWin);
		
		//starta tudo do win win como false!
		
		showWinWin(false);
		
		 chckbxWinWin = new JCheckBox("Win Win?");
		chckbxWinWin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxWinWin.isSelected()) {
					showWinWin(true);
				}else {
					showWinWin(false);
				}
			}
		});
		chckbxWinWin.setBounds(31, 181, 102, 23);
		contentPane.add(chckbxWinWin);
		

		btnCadastrarBet.setBounds(31, 215, 117, 29);
		contentPane.add(btnCadastrarBet);
		
	}
	public void addKeyListenerTxtFieldStake(KeyAdapter action){
		txtFieldStake.addKeyListener(action);
	}
	public void addActionToBtnCadastrarBet(ActionListener action) {
		btnCadastrarBet.addActionListener(action);
	}
	public Casa getSelectedCasa() {
		return (Casa) comboBoxCasa.getSelectedItem();
	}
	public double getOdd() {
		return Double.parseDouble(txtFieldOdd.getText());
	}
	public double getStake(){
		return Double.parseDouble(txtFieldStake.getText());
	}
	public boolean getGreen() {
		return chckbxGreen.isSelected();
	}
	public double getLucro() {
		return lucro;
	}
	
	public AdicionarBet(UsuarioPadrao usuario, Home home) {
		this.usuario = usuario;
		initComponentes();	
	}
}
