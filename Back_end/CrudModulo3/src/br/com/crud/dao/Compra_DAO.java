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
import br.com.crud.model.CompraModel;
import br.com.crud.model.PassagemModel;

public class Compra_DAO {

	
		private static final String DB_URL = "jdbc:mysql://localhost:3306";
		private static final String DB_USER = "root";
		private static final String DB_PASSWORD = "2563724Gfh";
		
		private static final String SELECT_SQL = "select*from agencia.Cliente_Passagem;";
		private static final String INSERT_SQL = "INSERT INTO agencia.compra (data_compra, id_cliente, id_passagem, metodo_pagamento, total_compra) VALUES (?, ?, ?, ?, ?)";
		private static final String UPDATE_SQL = "UPDATE agencia.compra SET data_compra = ?, id_cliente = ?, id_passagem = ?, metodo_pagamento = ?, total_compra = ? WHERE id_compra = ?";
		private static final String DELETE_SQL = "DELETE FROM agencia.compra WHERE id_compra = ?";
		private static final String READ_ID = "SELECT * FROM agencia.Cliente_Passagem WHERE id_compra = ?";
		
	
		public static List<CompraModel> buscarcompra() {
			
			List<CompraModel> compras = new ArrayList<>();
			
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
					ClienteModel c1 = new ClienteModel ();
					PassagemModel p1 = new PassagemModel ();
					CompraModel co1 = new CompraModel ();
					
					co1.setId(rs.getInt("id_compra"));
					co1.setData_compra(rs.getString("data_compra"));
					co1.setMetodo_pagamento(rs.getString("metodo_pagamento"));
					co1.setTotal_compra(rs.getDouble("total_compra"));
					
					p1.setId_passagem(rs.getInt("id_passagem"));
					p1.setCidade(rs.getString("cidade"));
					p1.setData_passagem(rs.getString("data_passagem"));
					p1.setPreço(rs.getDouble("preço")); 
					p1.setCategoria(rs.getString("categoria"));
					
					c1.setId_cliente(rs.getInt("id_cliente"));
					c1.setCpf(rs.getInt("cpf"));
					c1.setIdade(rs.getInt("idade"));
					c1.setAcompanhantes(rs.getInt("acompanhantes"));
					c1.setNome(rs.getString("nome"));
					c1.setEmail(rs.getString("email"));
					c1.setSenha(rs.getString("senha"));
					
					co1.setC1(c1);
					co1.setP1(p1);
					
					
					compras.add(co1);
					
					
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
				return compras;
				
			}
		
		public static boolean inserircompra(CompraModel co1) {
			
			boolean sucesso = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
		
			try {
				Driver driver = new Driver();	
				DriverManager.registerDriver(driver);
				
				 c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				 stmt = c.prepareStatement(INSERT_SQL);
				 
				stmt.setString (1, co1.getData_compra());
				stmt.setInt (2, co1.getC1().getId_cliente());
				stmt.setInt (3, co1.getP1().getId_passagem());
				stmt.setString(4, co1.getMetodo_pagamento());
				stmt.setDouble (5, co1.getTotal_compra());
				
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
	 
		public static boolean atualizarcompra(CompraModel co1) {
			Scanner scanner = new Scanner(System.in);
			
			boolean sucesso = false;
			
			Connection c = null;
			PreparedStatement stmt = null;
				
				try {
					Driver driver = new Driver();	
					DriverManager.registerDriver(driver);
					
					 c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					
					 stmt = c.prepareStatement(UPDATE_SQL);
					
					 
						stmt.setString (1, co1.getData_compra());
						stmt.setInt (2, co1.getC1().getId_cliente());
						stmt.setInt (3, co1.getP1().getId_passagem());
						stmt.setString(4, co1.getMetodo_pagamento());
						stmt.setDouble (5, co1.getTotal_compra());
						stmt.setInt(6, co1.getId());
					
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
			
		public static boolean deletarcompra(int id_compra ) {
			
			boolean sucesso = false;  
			
			Connection c = null;
			PreparedStatement stmt = null;
			
				try {
					Driver driver = new Driver();	
					DriverManager.registerDriver(driver);
					
					c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
					
					stmt = c.prepareStatement(DELETE_SQL);
					
					stmt.setInt(1, id_compra);
					
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
		
		public static CompraModel buscarId (int id_compra) {
			CompraModel co1 = new CompraModel ();
			 
			Connection c = null;
			PreparedStatement stmt = null;
			
			try {
				Driver driver = new Driver();	
				DriverManager.registerDriver(driver);
				
				c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				
				stmt = c.prepareStatement(READ_ID);
				
				stmt.setInt(1, id_compra);
				
				ResultSet rs = stmt.executeQuery();
				
				rs.next();

				
				ClienteModel c1 = new ClienteModel ();
				PassagemModel p1 = new PassagemModel ();
				
				co1.setId(rs.getInt("id_compra"));
				co1.setData_compra(rs.getString("data_compra"));
				co1.setMetodo_pagamento(rs.getString("metodo_pagamento"));
				co1.setTotal_compra(rs.getDouble("total_compra"));
				
				p1.setId_passagem(rs.getInt("id_passagem"));
				p1.setCidade(rs.getString("cidade"));
				p1.setData_passagem(rs.getString("data_passagem"));
				p1.setPreço(rs.getDouble("preço")); 
				p1.setCategoria(rs.getString("categoria"));
				
				c1.setId_cliente(rs.getInt("id_cliente"));
				c1.setCpf(rs.getInt("cpf"));
				c1.setIdade(rs.getInt("idade"));
				c1.setAcompanhantes(rs.getInt("acompanhantes"));
				c1.setNome(rs.getString("nome"));
				c1.setEmail(rs.getString("email"));
				c1.setSenha(rs.getString("senha"));
				
				co1.setC1(c1);
				co1.setP1(p1);
				
				
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
				return co1;

     }
}