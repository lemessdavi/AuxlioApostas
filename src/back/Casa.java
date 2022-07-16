package back;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Casa {
	private String nome;
	private double banca;
	private double bancaPadrao;
	private double lucro;
	private Set<Bet> bets = new HashSet<Bet>();
	
	public Casa(String nome, double banca) {
		this.nome = nome;
		this.banca = banca;
		this.bancaPadrao = banca;
	}
	
	public double getBanca() {
		return banca;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void saque(double quantiaSaque){
		bancaPadrao -= quantiaSaque;
		banca -= quantiaSaque;
	}
	public void deposito(double quantiaSaque){
		bancaPadrao += quantiaSaque;
		banca += quantiaSaque;
	}
	
	public Set<Bet> getBets() {
		return bets;
	}
	
	public double getLucro() {
		return lucro;
	}
	
	
	public void refreshLucro() {
		lucro = 0;
		for (Bet bet : bets) {
			lucro += bet.getLucro();
		}
		banca += lucro;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
