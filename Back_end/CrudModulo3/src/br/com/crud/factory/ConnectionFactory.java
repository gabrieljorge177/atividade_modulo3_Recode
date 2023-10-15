package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuário do Mysql
	private static final String USERNAME = "root";
	
	//Senha do MySql
	private static final String PASSWORD = "2563724Gfh";
	
	
	private static final String DATABASE_URL =
	"jdbc:mysql://localhost:3306/agencia";
	
	/**
	 * @param username
	 * @param senha
	 * @return uma conexão com o banco de dados
	 * @throws Exception
	 */
	
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver"); //Faz com o que a classe
		//seja carregada pela JVM
		
		//cria a conexão com o banco de dados
		Connection connection =
	DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception{
		//recupera uma conexao com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//testa se a conexão é nula
		if(con != null) {
			System.out.println("Conexão obtida com sucesso!" + con);
			con.close();
	
		}
	}
}