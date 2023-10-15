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

import br.com.crud.model.PassagemModel;

public class Passagem_DAO {

	
		private static final String DB_URL = "jdbc:mysql://localhost:3306";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "2563724Gfh";
		
		private static final String SELECT_SQL = "SELECT * FROM agencia.passagem";
		private static final String INSERT_SQL = "INSERT INTO agencia.passagem (cidade, data_passagem, preço, categoria) VALUES (?,?,?,?)";
		private static final String UPDATE_SQL = "UPDATE agencia.passagem SET cidade = ?, data_passagem = ?, preço = ?, categoria = ? WHERE id_passagem = ?";
		private static final String DELETE_SQL = "DELETE FROM agencia.passagem WHERE id_passagem = ?";
		private static final String READ_ID = "SELECT * FROM agencia.passagem WHERE id_passagem = ?";
		
	
		public static List<PassagemModel> buscarPassagem() {
			
			List<PassagemModel> passagens = new ArrayList<>();
			
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
					
					int id_passagem = rs.getInt("id_passagem");
					String cidade = rs.getString("cidade");
					String data_passagem = rs.getString("data_passagem");
					double preço = rs.getDouble("preço");
					String categoria = rs.getString("categoria");
					
					PassagemModel p1 = new PassagemModel ();
					p1.setId_passagem(id_passagem);;
					p1.setCidade(cidade);
					p1.setData_passagem(data_passagem);
					p1.setPreço(preço);
					p1.setCategoria(categoria);
					
					
					passagens.add(p1);
					
					
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
				return passagens;
				
			}
		
		public boolean inserirPassagem(PassagemModel p1) {
			
			boolean sucesso = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
		
			try {
				Driver driver = new Driver();	
				DriverManager.registerDriver(driver);
				
				 c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				 stmt = c.prepareStatement(INSERT_SQL);
				 
				stmt.setString (1, p1.getCidade());
				stmt.setString (2, p1.getData_passagem());
				stmt.setDouble (3, p1.getPreço());
				stmt.setString (4, p1.getCategoria());
				
				
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
	 
		public static boolean atualizarPassagem(PassagemModel p1) {
			Scanner scanner = new Scanner(System.in);
			
			boolean sucesso = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
				
				try {
					Driver driver = new Driver();	
					DriverManager.registerDriver(driver);
					
					 c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					
					 stmt = c.prepareStatement(UPDATE_SQL);
					
					 	stmt.setString (1, p1.getCidade());
						stmt.setString (2,p1.getData_passagem());
						stmt.setDouble (3, p1.getPreço());
						stmt.setString (4, p1.getCategoria());
				        stmt.setInt(5, p1.getId_passagem());
					
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
			
		public static boolean deletarPassagem(int id_passagem ) {
			
			boolean sucesso = false;  
			
			Connection c = null;
			PreparedStatement stmt = null;
			
				try {
					Driver driver = new Driver();	
					DriverManager.registerDriver(driver);
					
					c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					
					stmt = c.prepareStatement(DELETE_SQL);
					
					stmt.setInt(1, id_passagem);
					
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
		
		public static PassagemModel buscarId (int id_passagem) {
			PassagemModel p1 = new PassagemModel ();
			 
			Connection c = null;
			PreparedStatement stmt = null;
			
			try {
				Driver driver = new Driver();	
				DriverManager.registerDriver(driver);
				
				c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				stmt = c.prepareStatement(READ_ID);
				
				stmt.setInt(1, id_passagem);
				
				ResultSet rs = stmt.executeQuery();
				
				rs.next();
				
				p1.setId_passagem(rs.getInt("id_passagem"));
                p1.setCidade(rs.getString("cidade"));
                p1.setData_passagem(rs.getString("data_passagem"));
                p1.setPreço(rs.getDouble("preço"));
                p1.setCategoria(rs.getString("categoria"));
				  
				
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
				return p1;

     }
}