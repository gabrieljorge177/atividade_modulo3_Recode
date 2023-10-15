package br.com.crud.console;

import br.com.crud.dao.Cliente_DAO;
import br.com.crud.dao.Compra_DAO;
import br.com.crud.dao.Passagem_DAO;
import br.com.crud.model.ClienteModel;
import br.com.crud.model.CompraModel;
import br.com.crud.model.PassagemModel;

import java.util.Scanner;

public class CompraCRUD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compra_DAO compraDAO = new Compra_DAO();
        Cliente_DAO clienteDAO = new Cliente_DAO();
        Passagem_DAO passagemDAO = new Passagem_DAO();

        int opcao = 0;
        String data_compra;
        int id_compra = 0;
        int id_cliente = 0;
        int id_passagem = 0;
        String metodo_pagamento;
        Double total_compra = 0.0;

        do {
            System.out.println("\n======================= Compra ========================\n");
            System.out.println("1-Criar   2-Consultar    3-Atualizar  4-Deletar  5-Consultar por ID 0-sair");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro");
                    System.out.print("Digite a data da compra: ");
                    data_compra = scanner.nextLine();
                    System.out.print("Digite o id da cliente: ");
                    id_cliente = scanner.nextInt();
                    System.out.print("Digite o id da passagem: ");
                    id_passagem = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Qual a forma de pagamento da sua viagem? ");
                    metodo_pagamento = scanner.nextLine();
                
                    ClienteModel c1 = Cliente_DAO.buscarId(id_cliente);
                    PassagemModel p1 = Passagem_DAO.buscarId(id_passagem);

                    CompraModel co1 = new CompraModel(data_compra,id_compra, c1, p1, metodo_pagamento, total_compra);
                    
                    Compra_DAO.inserircompra(co1);

                   
                    break;
                    
                case 2:
                    for (CompraModel co2: Compra_DAO.buscarcompra()) {
                        System.out.println(co2.toString());
                    }
                    break;
                    
                case 3: 
                	 System.out.println("Cadastro");
                	 System.out.println("Digite o Id da compra");
                	 id_compra = scanner.nextInt();
                	 scanner.nextLine();
                     System.out.print("Digite a data da compra: ");
                     data_compra = scanner.nextLine();
                     System.out.print("Digite o id da cliente: ");
                     id_cliente = scanner.nextInt();
                     System.out.print("Digite o id da passagem: ");
                     id_passagem = scanner.nextInt();
                     scanner.nextLine();
                     System.out.println("Qual a forma de pagamento da sua viagem? ");
                     metodo_pagamento = scanner.nextLine();
                    

                     ClienteModel c2 = Cliente_DAO.buscarId(id_cliente);
                     PassagemModel p2 = Passagem_DAO.buscarId(id_passagem);

                     CompraModel co2 = new CompraModel( data_compra, id_compra, c2, p2, metodo_pagamento, total_compra);
                     
                     Compra_DAO.atualizarcompra(co2);
            		
            		break;
            		
            	case 4:
            		
            		System.out.println("Digite o ID que deseja remover: ");
            		id_compra = scanner.nextInt();
            		scanner.nextLine();
            		
            		Compra_DAO.deletarcompra(id_compra);
            		
            		break;
            		
            	case 5:
            		
            		System.out.println("Digite o ID que deseja buscar: ");
            		id_compra = scanner.nextInt();
            		scanner.nextLine();
            		
            		CompraModel co4 = Compra_DAO.buscarId(id_compra);
            		System.out.println(co4.toString());
            		break;
            		
            		
            		default:
            			System.out.println(opcao != 0 ? "Opção Inválida. Tente digitar novamente" : "");
            			break;
            		
            }
        } while (opcao != 0);

        System.out.println("Obrigado pela preferência");
    }
}
