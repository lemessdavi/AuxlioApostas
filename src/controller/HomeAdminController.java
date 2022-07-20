package controller;

import model.Admin;
import view.HomeAdmin;

public class HomeAdminController {
	HomeAdmin viewHome;
	
	public HomeAdminController(Admin admin) {
		viewHome = new HomeAdmin(admin);
		exibirView(true);
	}
	
	private void exibirView(boolean x) {
		viewHome.setVisible(x);
	}
	
}
