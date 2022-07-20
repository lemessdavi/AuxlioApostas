package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	protected int id;
	protected String login;
	protected String senha;
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
				
	}
	
	public String getLogin() {
		return login;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}

	
}
