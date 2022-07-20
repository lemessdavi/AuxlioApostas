package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Admin;
import view.CadastroUsuario;
import view.Home;
import view.HomeAdmin;
import view.Login;
import view.TelaErro;

public class LoginController {
	Login viewLogin;
	
	public LoginController() {
		viewLogin = new Login();
		exibirView(true);
		addActionToButtons();
	}
	
	public void exibirView(boolean x) {
		viewLogin.setVisible(x);
	}
	
	public void disposeView() {
		viewLogin.dispose();
	}
	
	public void initCadastroUsuario() {
		CadastroUsuarioController cadastroUsuario = new CadastroUsuarioController(viewLogin);
	}
	
	public void initHome() {
		if (viewLogin.autenticaUsuario()) {
			if(viewLogin.getUsuarioLogado().getClass() == Admin.class) {
				HomeAdminController home = new HomeAdminController(((Admin) viewLogin.getUsuarioLogado()));
				disposeView();
			}else {
				HomeController home = new HomeController(viewLogin.getUsuarioLogado());
				disposeView();
			}
		}else {

			TelaErro telaErro = new TelaErro("Dados Incorretos");
			telaErro.setVisible(true);
		}
		
	}
	
	
	public void addActionToButtons() {
		viewLogin.addActionBtnLogin(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				initHome();
			}
		});
		viewLogin.addActionBtnCadastrar(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				initCadastroUsuario();
			}
		});
	}
}
