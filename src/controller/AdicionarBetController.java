package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Bet;
import model.Casa;
import model.IDecimalFormat;
import model.UsuarioPadrao;
import view.AdicionarBet;
import view.Home;

public class AdicionarBetController implements IDecimalFormat {
	private UsuarioPadrao modelUsuario;
	private AdicionarBet viewAddBet;
	private Home viewHome;
	
	public AdicionarBetController(UsuarioPadrao modelUsuario, Home viewHome ) {
		this.viewAddBet = new AdicionarBet(modelUsuario, viewHome);
		this.modelUsuario = modelUsuario;
		this.viewHome = viewHome;
		exibirView(true);
		addActionToButtons();
	}
	
	private void exibirView(boolean x) {
		viewAddBet.setVisible(x);
	} 
	
	private void addActionToButtons() {
		viewAddBet.addKeyListenerTxtFieldStake(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				keyActionFieldStake();
			}
		});
		viewAddBet.addActionToBtnCadastrarBet(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cadastrarBet();
			}
		});
	}
	
	private void keyActionFieldStake() {
		viewAddBet.atualizaLucro();
	}
	
	private void cadastrarBet() {
		 double odd = viewAddBet.getOdd();
		 double stake = viewAddBet.getStake();
		 boolean green = viewAddBet.getGreen();
		 double lucro = viewAddBet.getLucro();
		 Casa casa = viewAddBet.getSelectedCasa();
				 
		 Bet bet = new Bet(odd, stake, green, lucro, casa);
		 casa.refreshLucro();
		 modelUsuario.refreshLucroTotal();
		 viewHome.getTextFieldLucro().setText(setDecimal(((UsuarioPadrao) modelUsuario).getLucroTotal()));
		 viewHome.addRowToJTabel();
	}
}
