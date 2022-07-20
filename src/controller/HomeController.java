package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Usuario;
import model.UsuarioPadrao;
import view.AdicionarBet;
import view.Home;

public class HomeController {
	Home viewHome;
	Usuario modelUsuario;
	
	public HomeController(Usuario usuario) {
		modelUsuario = usuario;
		viewHome = new Home(usuario);
		exibirView(true);
		addActionToButtons();
	}
	
	private void exibirView(boolean x) {
		viewHome.setVisible(x);
	}
	
	private void addActionToButtons() {
		viewHome.addActionToBtnAddBet(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddBetAction();
			}
		});
		viewHome.addActionToBtnAddCasa(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddCasaAction();
			}
		});
		viewHome.addActionToBtnAlterar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAlterarAction();
			}
		});
	}
	
	private void btnAddBetAction() {
		AdicionarBetController addBetController = new AdicionarBetController((UsuarioPadrao)modelUsuario, viewHome);
		
	}
	private void btnAddCasaAction() {
		AdicionarCasaController addCasaController = new AdicionarCasaController((UsuarioPadrao) modelUsuario, viewHome);
	}
	private void btnAlterarAction() {
		AlterarBancaController altBancaController = new AlterarBancaController((UsuarioPadrao) modelUsuario, viewHome);
		
	}
}
