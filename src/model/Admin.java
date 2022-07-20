package model;

import java.util.List;

import dao.DAO;

public class Admin extends Usuario {
	public List<UsuarioPadrao> usuarios;

	public Admin(String login, String senha) {
		super(login, senha);
		this.usuarios = DAO.getUsuariosPadrao();
		DAO.addAdmin(this);
	}

}
