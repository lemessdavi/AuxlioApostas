package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Admin;
import model.Casa;
import model.Usuario;
import model.UsuarioPadrao;
import view.CadastroUsuario;
import view.Login;
import view.TelaCom;

public class CadastroUsuarioController {
	CadastroUsuario viewCadastroUsuario;
	Login viewLogin;
	
	public CadastroUsuarioController(Login view) {
		viewCadastroUsuario = new CadastroUsuario(view);
		viewLogin = view;
		addActionToButtons();
		exibirView(true);
		
	}
	
	public void exibirView(boolean x) {
		viewCadastroUsuario.setVisible(x);
	}
	
	private void addActionToButtons() {
		viewCadastroUsuario.addActionBtnCadastrarUsuario(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnCadastrar();
			}
		});
	}
	
	public void actionBtnCadastrar() {
		String nome = viewCadastroUsuario.getNome();
		String senha = viewCadastroUsuario.getSenha();
		
		
		Usuario usuario;
		if (viewCadastroUsuario.isAdm()) {
			usuario = new Admin(nome, senha);
			viewCadastroUsuario.dispose();
		} else {
			try {
				Double banca = viewCadastroUsuario.getBanca();
				String nomeCasa = viewCadastroUsuario.getNomeCasa();
				Casa casa = new Casa(nomeCasa,banca);
				usuario = new UsuarioPadrao(nome,senha, casa );
				viewLogin.addRowToJTabel();
				viewCadastroUsuario.dispose();
			} catch (NumberFormatException ex) {
				TelaCom telaErro = new TelaCom("Insira Apenas Números");
				telaErro.setVisible(true);
			}
			
		}
		
	}
}
