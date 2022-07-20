package controller;

import model.Usuario;
import view.Home;

public class HomeController {
	Home viewHome;
	Usuario modelUsuario;
	
	public HomeController(Usuario usuario) {
		modelUsuario = usuario;
		viewHome = new Home(usuario);
		exibirView(true);
	}
	
	private void exibirView(boolean x) {
		viewHome.setVisible(x);
	}
	
}
