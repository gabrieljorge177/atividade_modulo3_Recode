package br.com.crud.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

import br.com.crud.model.ClienteModel;

//Classe DAO -> DATA ACESS OBJECT 

public class Cliente_DAO {
	private static final String DB_URL = "jdbc:mysql://localhost:3306";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "2563724Gfh";
	
	private static final String SELECT_SQL = "SELECT * FROM agencia.Cliente";
	private static final String INSERT_SQL = "INSERT INTO agencia.Cliente (cpf, idade, acompanhantes, nome, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_SQL = "UPDATE agencia.cliente SET cpf = ?, idade = ?, acompanhantes = ?, nome = ?, email = ?, senha = ? WHERE id_cliente = ?";
	private static final String DELETE_SQL = "DELETE FROM agencia.cliente WHERE id_cliente = ?";
	private static final String READ_ID = "SELECT * FROM agencia.Cliente WHERE id_cliente = ?";
	

	public static List<ClienteModel> buscarCliente() {
		
		List<ClienteModel> clientes = new ArrayList<>();
		
		Connection c = null;
		PreparedStatement stmt = null;

		//java database connection (jdbc)
		try {
			Driver driver = new Driver();	
			DriverManager.registerDriver(driver);
			
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
		    stmt = c.prepareStatement(SELECT_SQL);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int id_cliente = rs.getInt("id_cliente");
				int cpf = rs.getInt("cpf");
				int idade = rs.getInt("idade");
				int acompanhantes = rs.getInt("Acompanhantes");
				String nome = rs.getString("Nome");
				String email = rs.getString("Email");
				String senha = rs.getString("Senha");
				
				ClienteModel c1 = new ClienteModel ();
				c1.setId_cliente(id_cliente);
				c1.setCpf(cpf);
				c1.setIdade(idade);
				c1.setAcompanhantes(acompanhantes);
				c1.setNome(nome);
				c1.setEmail(email);
				c1.setSenha(senha);
				
				clientes.add(c1);
				
				
			}
			stmt.close();
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (c != null) {
	                c.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
			return clientes;
			
		}
	
	public static boolean inserirCliente(ClienteModel c1) {
		
		boolean sucesso = false;
		
		Connection c = null;
		PreparedStatement stmt = null;
	
		try {
			Driver driver = new Driver();	
			DriverManager.registerDriver(driver);
			
			 c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			 stmt = c.prepareStatement(INSERT_SQL);
			 
			stmt.setInt (1, c1.getCpf());
			stmt.setInt (2,c1.getIdade());
			stmt.setInt (3, c1.getAcompanhantes());
			stmt.setString (4, c1.getNome());
			stmt.setString (5, c1.getEmail());
			stmt.setString (6, c1.getSenha());
			
			int rowsAffected = stmt.executeUpdate();
			
			if (rowsAffected > 0) {
				sucesso = true;
			}	
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (c != null) {
	                c.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
			return sucesso;
			
		}
 
	public static boolean atualizarCliente(ClienteModel c1) {
		Scanner scanner = new Scanner(System.in);
		
		boolean sucesso = false;
		
		Connection c = null;
		PreparedStatement stmt = null;
			
			try {
				Driver driver = new Driver();	
				DriverManager.registerDriver(driver);
				
				 c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				 stmt = c.prepareStatement(UPDATE_SQL);
				
				 	stmt.setInt(1, c1.getCpf());
			        stmt.setInt(2, c1.getIdade());
			        stmt.setInt(3, c1.getAcompanhantes());
			        stmt.setString(4, c1.getNome());
			        stmt.setString(5, c1.getEmail());
			        stmt.setString(6, c1.getSenha());
			        stmt.setInt(7, c1.getId_cliente());
				
				int rowsAffected = stmt.executeUpdate();
				
				if (rowsAffected > 0) {
					sucesso = true;
				}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (c != null) {
	                c.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
			return sucesso;
			
		}
		
	public static boolean deletarCliente(int id_cliente ) {
		
		boolean sucesso = false;  
		
		Connection c = null;
		PreparedStatement stmt = null;
		
			try {
				Driver driver = new Driver();	
				DriverManager.registerDriver(driver);
				
				c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				stmt = c.prepareStatement(DELETE_SQL);
				
				stmt.setInt(1, id_cliente);
				
				int rowsAffected = stmt.executeUpdate();
				
				if (rowsAffected > 0) {
					sucesso = true;
				} 
			
			} catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (stmt != null) {
		                stmt.close();
		            }
		            if (c != null) {
		                c.close();
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
			return sucesso;
	}
	
	public static ClienteModel buscarId (int id_cliente ) {
		ClienteModel c1 = new ClienteModel ();
		 
		Connection c = null;
		PreparedStatement stmt = null;
		
		try {
			Driver driver = new Driver();	
			DriverManager.registerDriver(driver);
			
			c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			
			stmt = c.prepareStatement(READ_ID);
			
			stmt.setInt(1, id_cliente);
			
			ResultSet rs = stmt.executeQuery();
			
			rs.next();
			
			c1.setCpf(rs.getInt("cpf"));
			c1.setIdade(rs.getInt("idade"));
			c1.setAcompanhantes(rs.getInt("acompanhantes"));
			c1.setNome(rs.getString("nome"));
			c1.setId_cliente(rs.getInt("id_cliente"));
			c1.setEmail(rs.getString("email"));
			c1.setSenha(rs.getString("senha"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (c != null) {
	                c.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
			return c1;
			
		}

}
