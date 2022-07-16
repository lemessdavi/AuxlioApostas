package model;

import java.util.List;

import banco.BD;

public class Admin extends Usuario {
	public List<UsuarioPadrao> usuarios;

	public Admin(String login, String senha) {
		super(login, senha);
		this.usuarios = BD.getUsuariosPadrao();
		BD.addAdmin(this);
	}

}
