package controller;

import model.Bet;
import view.AdicionarBet;

public class AdicionarBetController {
	private Bet modelBet;
	private AdicionarBet viewAddBet;
	
	public AdicionarBetController(Bet bet, AdicionarBet tela) {
		this.modelBet = bet;
		this.viewAddBet = tela;
	}
	
}
