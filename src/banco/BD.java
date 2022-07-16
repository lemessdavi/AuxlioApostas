package banco;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import back.Admin;
import back.Bet;
import back.Casa;
import back.Comparator;
import back.Usuario;
import back.UsuarioPadrao;

public class BD {
	private static List<Usuario> usuarios = new ArrayList<>();
	private static List<UsuarioPadrao> usuariosPadrao = new ArrayList<>();
	private static List<Admin> admins = new ArrayList<>();
	private static Map<UsuarioPadrao, List<Casa>> mapUsuarioCasa = new TreeMap();

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
		usuariosPadrao.add(usuario1);
		usuarios.add(usuario1);
	}
	
	public static void addAdmin(Admin admin) {
		admins.add(admin);
		usuarios.add(admin);
	}

	
	public static void refreshMapUsuarioCasa() {
		mapUsuarioCasa.clear();
		usuariosPadrao.forEach((usuario) -> mapUsuarioCasa.put(usuario, usuario.getCasas()));
	}
	
	
}
