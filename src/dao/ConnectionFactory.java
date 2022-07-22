package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

	public Connection connection;
	
	public ConnectionFactory() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/","root",																													"Slytherin8");
	
		
	}

	public Connection recuperarConexao() {
		return this.connection;
		
	}
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory cFactory = new ConnectionFactory();
		Connection connection = cFactory.recuperarConexao();
		
		System.out.println("Conexão Funcionando :)");
		
		connection.close();
	}
}
