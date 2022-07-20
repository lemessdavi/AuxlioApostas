package controller;

import model.Usuario;
import model.UsuarioPadrao;
import view.AlterarBanca;
import view.Home;

public class AlterarBancaController {
	Usuario modelUsuario;
	Home  viewHome;
	AlterarBanca viewAlterarBanca;
		
	public AlterarBancaController(UsuarioPadrao modelUsuario, Home viewHome) {
		this.modelUsuario = modelUsuario;
		this.viewHome = viewHome;
		viewAlterarBanca = new AlterarBanca(modelUsuario, viewHome);
		exibirView(true);
		addActionToButtons();
	}
	
	private void exibirView(boolean x) {
		viewAlterarBanca.setVisible(x);
	}

	private void addActionToButtons() {
		
		
	}
}
