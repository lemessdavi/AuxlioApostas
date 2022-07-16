package back;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import banco.BD;

public class UsuarioPadrao extends Usuario implements Comparable<UsuarioPadrao>{
	private ArrayList<Casa> casas = new ArrayList<>();
	private double bancaTotal;
	private double lucroTotal;
	
	
	// caso hajam varias casas a serem inseridas;
	public UsuarioPadrao(String login, String senha, ArrayList<Casa> casas) {
		super(login, senha);
		this.casas = casas;
		casas.forEach((casa) -> bancaTotal = bancaTotal + casa.getBanca());
		BD.addUsuarioPadrao(this);
	}
	
	//caso seja inserida apenas uma casa
	public UsuarioPadrao(String login, String senha, Casa casa) {
		super(login, senha);
		this.casas.add(casa);
		bancaTotal = casa.getBanca();
		BD.addUsuarioPadrao(this);
	}
	
	public void setBancaTotal() {
		bancaTotal = 0;
		casas.forEach(c -> bancaTotal += c.getBanca());
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}
	public double getBancaTotal() {
		setBancaTotal();
		return bancaTotal;
	}
	public void setCasas(ArrayList<Casa> casas) {
		this.casas = casas;
	}
	public void addCasa(Casa casa) {
		casas.add(casa);
		setBancaTotal();
	}
	public void setLucroTotal() {
		for (Casa casa : casas) {
			lucroTotal += casa.getLucro();
		}
	}
	public void refreshLucroTotal() {
		lucroTotal = 0;
		for (Casa casa : casas) {
			lucroTotal += casa.getLucro();
		}
	}
	
	public double getLucroTotal() {
		return lucroTotal;
	}

	@Override
	public int compareTo(UsuarioPadrao o) {
		return this.login.compareTo(o.login);
	}
}
