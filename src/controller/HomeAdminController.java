package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import dao.DAO;
import model.Admin;
import model.Comparator;
import view.HomeAdmin;

public class HomeAdminController {
	HomeAdmin viewHome;
	
	public HomeAdminController(Admin admin) {
		viewHome = new HomeAdmin(admin);
		exibirView(true);
		addActionToButtons();
	}
	
	private void exibirView(boolean x) {
		viewHome.setVisible(x);
	}
	
	private void addActionToButtons() {
		viewHome.addActionToCbOrdem(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionCbOrdem();
			}
		});
	}
	
	private void actionCbOrdem() {
		
		String ordem = viewHome.getSelectedOrdem();
		
		if(ordem.equals("Alfabética")) {
			Collections.sort(DAO.getUsuariosPadrao());
			viewHome.addRowToJTabel();
		}
		else {
			 Comparator comparator = new Comparator(ordem);
			 Collections.sort(DAO.getUsuariosPadrao(), comparator);
			 viewHome.addRowToJTabel();
		}
	}
}
