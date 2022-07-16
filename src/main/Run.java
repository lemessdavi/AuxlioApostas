package main;

import java.util.ArrayList;
import java.util.List;

import banco.BD;
import model.Admin;
import model.Casa;
import model.Usuario;
import model.UsuarioPadrao;
import view.Login;

public class Run {
	
	public static void main(String[] args) {
		
		
		Casa denise = new Casa("Bet365", 1000.00);
		Casa luiz = new Casa("Rivarly", 2000.00);
		ArrayList<Casa> casas = new  ArrayList();
		
		casas.add(denise);
		casas.add(luiz);
		
		Casa denise2 = new Casa("Bet365", 7000.00);
		Casa pinnacle = new Casa("Pinnacle", 5000.00);
		ArrayList<Casa> casas2 = new  ArrayList();
		
		casas2.add(denise2);
		casas2.add(pinnacle);
		
		Casa denise3 = new Casa("Bet365", 800.00);
		Casa pinnacle2 = new Casa("Pinnacle", 200.00);
		ArrayList<Casa> casas3 = new  ArrayList();
		
		Usuario usuario1 = new UsuarioPadrao("Artur", "caramelo",casas2);
		Usuario usuari21 = new UsuarioPadrao("Joao", "caramelo",casas);
		Usuario usuario13 = new UsuarioPadrao("Bruno", "caramelo",casas3);
		
		
		Usuario admin = new Admin("admin", "admin");
		
		Login telaLogin = new Login();
		telaLogin.setVisible(true);
		
	}
}
