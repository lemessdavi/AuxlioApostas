package dao;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import model.Admin;
import model.Bet;
import model.Casa;
import model.Comparator;
import model.Usuario;
import model.UsuarioPadrao;

public class DAO {
	private static List<Usuario> usuarios = new ArrayList<>();
	private static List<UsuarioPadrao> usuariosPadrao = new ArrayList<>();
	private static List<Admin> admins = new ArrayList<>();
	private static Map<UsuarioPadrao, List<Casa>> mapUsuarioCasa;

	public static List<UsuarioPadrao> getUsuariosPadrao() { 
		return usuariosPadrao;
	}
	
	public static List<Admin> getAdmins() { 
		return admins;
	}
	
	public static List<Usuario> getUsuarios(){
		return usuarios;
	}
	
	
	
	public static void addUsuarioPadrao(UsuarioPadrao usuario1) {
		//metodo pra dar add no banco
		usuariosPadrao.add(usuario1);
		usuarios.add(usuario1);
	}
	
	public static void addAdmin(Admin admin) {
		//metodo pra dar add no banco
		admins.add(admin);
		usuarios.add(admin);
	}

	
	public static void refreshMapUsuarioCasa() {
		mapUsuarioCasa.clear();
		usuariosPadrao.forEach((usuario) -> mapUsuarioCasa.put(usuario, usuario.getCasas()));
	}
	
	public static void deleteAllFromBanco() {
		//deleta tudo do banco, pra fins de teste 
	}
	
	
}
