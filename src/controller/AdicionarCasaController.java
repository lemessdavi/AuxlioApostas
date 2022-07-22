package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Casa;
import model.Usuario;
import model.UsuarioPadrao;
import view.Home;
import view.TelaCom;
import view.AdicionarCasa;

public class AdicionarCasaController {
	UsuarioPadrao modelUsuario;
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
		viewCasa.addActionBtnAddCasa(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnAddCasa();
			}
		});
	}
	
	private void actionBtnAddCasa() {
		String nomeCasa = viewCasa.getNomeCasa();
		double banca = viewCasa.getBanca();
		
		modelUsuario.addCasa(new Casa(nomeCasa, banca)); 
		viewHome.addRowToJTabel();
		viewCasa.dispose();
		TelaCom msg = new TelaCom("Casa adicionada com sucesso!");
		msg.setVisible(true);
	}
}
