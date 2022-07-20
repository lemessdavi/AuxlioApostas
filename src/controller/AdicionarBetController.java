package controller;

import model.Bet;
import model.UsuarioPadrao;
import view.AdicionarBet;
import view.Home;

public class AdicionarBetController {
	private UsuarioPadrao modelUsuario;
	private AdicionarBet viewAddBet;
	private Home viewHome;
	
	public AdicionarBetController(UsuarioPadrao modelUsuario, Home viewHome ) {
		this.viewAddBet = new AdicionarBet(modelUsuario, viewHome);
		this.modelUsuario = modelUsuario;
		this.viewHome = viewHome;
	}
	
	
}
