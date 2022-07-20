package controller;

import model.Usuario;
import model.UsuarioPadrao;
import view.Home;
import view.AdicionarCasa;

public class AdicionarCasaController {
	Usuario modelUsuario;
	Home viewHome;
	AdicionarCasa viewCasa;
	
	public AdicionarCasaController(UsuarioPadrao modelUsuario, Home viewHome) {
		this.modelUsuario = modelUsuario;
		this.viewHome = viewHome;
		viewCasa = new AdicionarCasa(modelUsuario, viewHome);
		exibirView(true);
		addActionToButtons();
	}
	
	private void exibirView(boolean x) {
		viewCasa.setVisible(x);
	}

	private void addActionToButtons() {
		
	}
}
