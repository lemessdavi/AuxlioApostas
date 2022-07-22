package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Casa;
import model.Usuario;
import model.UsuarioPadrao;
import view.AlterarBanca;
import view.Home;
import view.TelaCom;

public class AlterarBancaController {
	Usuario modelUsuario;
	Home  viewHome;
	AlterarBanca viewAlterarBanca;
	Casa modelCasa;
	TelaCom viewTelaCom;
		
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
		viewAlterarBanca.addActionBtnAlterarBanca(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actionBtnAlterarBanca();
			}
		});
		
	}
	
	private void actionBtnAlterarBanca() {
		double quantia = viewAlterarBanca.getQuantia();
		String selectedOperation = viewAlterarBanca.getSelectedOperation();
		modelCasa = viewAlterarBanca.getCasa();
		
		if(selectedOperation.equals("Saque")) {
			modelCasa.saque(quantia);
		}else {
			modelCasa.deposito(quantia);
		}
		viewHome.addRowToJTabel();
		viewAlterarBanca.dispose();
		viewTelaCom = new TelaCom("Alteração feita com sucesso!");
		viewTelaCom.setVisible(true);
	}
}
