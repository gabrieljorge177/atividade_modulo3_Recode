package br.com.crud.console;

import java.util.Scanner;

import br.com.crud.dao.Passagem_DAO;
import br.com.crud.model.PassagemModel;


public class PassagemCRUD {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        Passagem_DAO passagemDAO = new Passagem_DAO();

	        int opcao = 0;
	        String cidade;
	        String data_passagem;
	        Double preço;
	        String categoria;
	        int id_passagem; 
	        
	        do {
	            System.out.println("\n======================= Cliente ========================\n");
	            System.out.println("1-Criar   2-Consultar    3-Atualizar  4-Deletar  5-Consultar por ID 0-sair");
	            opcao = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcao) {
	                case 1: 
	                	System.out.println("Cadastro");
	                	System.out.print("Digite a cidade de destino da viagem: ");
	                	cidade = scanner.nextLine();
	                	System.out.print("Digite a data da viagem: ");
	                	data_passagem = scanner.nextLine();
	                	System.out.print("Digite o preço: ");
	                	preço = scanner.nextDouble();
	                	scanner.nextLine(); // Consuma a nova linha pendente após a leitura do preço
	                	System.out.print("Digite a categoria da viagem desejada: ");
	                	categoria = scanner.nextLine();

	                    PassagemModel p1 = new PassagemModel(cidade, data_passagem, preço, categoria);

	                    boolean cadastrado = passagemDAO.inserirPassagem(p1);
	                    if (cadastrado) {
	                        System.out.println("----> Passagem cadastrada com sucesso");
	                    } else {
	                        System.out.println("----> Erro ao cadastrar a passagem");
	                    }
	                    break;
	                    
	                case 2:
	                    for (PassagemModel p2: Passagem_DAO.buscarPassagem()) {
	                        System.out.println(p2.toString());
	                    }
	                    break;
	                    
	                case 3: 
	                    System.out.print("Digite o ID da passagem que deseja atualizar: ");
	                    id_passagem = scanner.nextInt();
	                    scanner.nextLine(); // Limpa o buffer
	                    System.out.print("Digite a cidade: ");
	                    cidade = scanner.nextLine();
	                    System.out.print("Digite a data da passagem: ");
	                    data_passagem = scanner.nextLine();
	                    System.out.print("Digite o valor: ");
	                    preço = scanner.nextDouble();
	                    scanner.nextLine();
	                    System.out.print("Digite a categoria da viagem: ");
	                    categoria = scanner.nextLine();
	                    
	                    PassagemModel p3 = new PassagemModel(id_passagem, cidade, data_passagem, preço, categoria);
	                    
	                    Passagem_DAO.atualizarPassagem(p3);
	            		
	            		break;
	            		
	            	case 4:
	            		
	            		System.out.println("Digite o ID que deseja remover: ");
	            		id_passagem = scanner.nextInt();
	            		scanner.nextLine();
	            		
	            		Passagem_DAO.deletarPassagem(id_passagem);
	            		
	            		break;
	            		
	            	case 5:
	            		
	            		System.out.println("Digite o ID que deseja buscar: ");
	            		id_passagem = scanner.nextInt();
	            		scanner.nextLine();
	            		
	            		PassagemModel p4 = Passagem_DAO.buscarId(id_passagem);
	            		System.out.println(p4.toString());
	            		
	            }
	        } while (opcao != 0);

	        System.out.println("Obrigado pela preferência");
	    }
	
	}


