package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Admin;



public class ConnectionTest{
	
	public static void main(String[] args) throws SQLException{
		
		selectUsuarioPadrao();
		//PreparedStatement stmtAddAdmin = connection.prepareStatement("select * from tbAdmin;");
		
	}
	
	public static void selectAdmin() throws SQLException{
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		Statement stm = connection.createStatement();
		stm.execute("select * from AuxilioApostas.tbAdmin inner join AuxilioApostas.tbUsuario on AuxilioApostas.tbAdmin.fk_id_tbUsuario = AuxilioApostas.tbUsuario.id_tbUsuario");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()){
			Integer id = rst.getInt("fk_id_tbUsuario");
			String login = rst.getString("login");
			String senha = rst.getString("senha");
			
			System.out.println("Informacoes Admin: Id: "+id+" Login: "+login+" Senha: "+senha);
			//DAO.addAdmin(new Admin(id, login, senha));
		}
	}
	public static void selectUsuarioPadrao() throws SQLException{
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		Statement stm = connection.createStatement();
		stm.execute("select * from AuxilioApostas.tbUsuarioPadrao inner join AuxilioApostas.tbUsuario on AuxilioApostas.tbUsuarioPadrao.fk_id_tbUsuario = AuxilioApostas.tbUsuario.id_tbUsuario");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()){
			Integer id = rst.getInt("fk_id_tbUsuario");
			String login = rst.getString("login");
			String senha = rst.getString("senha");
			Double bancaTotal = rst.getDouble("banca_total");
			Double lucroTotal = rst.getDouble("lucro_total");
			
			

			System.out.println("Informacoes Usuario Padrao: Id: "+id+" login: "+login+" Senha: "+senha+" Banca Total: "+bancaTotal+" Lucro Total: "+lucroTotal);
			selectCasa(id);
			
			//DAO.addAdmin(new Admin(id, login, senha));
		}
	}
	public static void selectCasa(Integer id) throws SQLException{
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		Statement stm = connection.createStatement();
		stm.execute("select * from AuxilioApostas.tbCasa inner join AuxilioApostas.tbUsuarioPadrao on AuxilioApostas.tbUsuarioPadrao.fk_id_tbUsuario = AuxilioApostas.tbCasa.fk_id_tbUsuario where AuxilioApostas.tbCasa.fk_id_tbUsuario = "+id+";");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()){
			Integer idCasa = rst.getInt("id_tbCasa");
			String nome = rst.getString("nome");
			Double lucro = rst.getDouble("lucro");
			Double banca = rst.getDouble("banca");
			Integer idUsuarioPadrao = rst.getInt("fk_id_tbUsuario");
			
			

			System.out.println("  Informacoes Casa: Id: "+idCasa+" Nome: "+nome+" Lucro: "+lucro+" Banca: "+banca+" Id Usuario Padrao: "+idUsuarioPadrao);
			selectBet(idCasa);
			
			//DAO.addAdmin(new Admin(id, login, senha));
		}
	}
	public static void selectBet(Integer id) throws SQLException{
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		Statement stm = connection.createStatement();
		stm.execute("select * from AuxilioApostas.tbBet inner join AuxilioApostas.tbCasa on AuxilioApostas.tbBet.fk_id_tbCasa = AuxilioApostas.tbCasa.id_tbCasa where AuxilioApostas.tbBet.fk_id_tbCasa = "+id+";");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()){
			Integer idBet = rst.getInt("id_tbCasa");
			Double odd = rst.getDouble("odd");
			Boolean green = rst.getBoolean("green");
			Double stake = rst.getDouble("stake");
			Double lucro = rst.getDouble("lucro");
			Integer idCasa = rst.getInt("fk_id_tbCasa");
			
			

			System.out.println("    Informacoes Bet: Id: "+idBet+" Odd: "+odd+" Green: "+green+" Stake: "+stake+" Lucro: "+lucro+" Id Casa: "+idCasa);
			
			
			//DAO.addAdmin(new Admin(id, login, senha));
		}
	}
	
	
	public static void addAdmin(Admin admin, PreparedStatement stmt) {
		String login = admin.getLogin();
		String senha = admin.getSenha();
		
		
		
	}
	
	
}