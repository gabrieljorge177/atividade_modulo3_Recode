package br.com.crud.console;

import java.util.Scanner;

import br.com.crud.dao.Cliente_DAO;
import br.com.crud.model.ClienteModel;

public class ClienteCRUD {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente_DAO clienteDAO = new Cliente_DAO();

        int opcao = 0;
        int cpf;
        int idade;
        int acompanhantes;
        String nome;
        String email;
        String senha;
        int id_cliente; 
        
        do {
            System.out.println("\n======================= Cliente ========================\n");
            System.out.println("1-Criar   2-Consultar    3-Atualizar  4-Deletar  5-Consultar por ID 0-sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1: 
                    System.out.println("Cadastro");
                    System.out.print("Digite seu cpf ");
                    cpf = scanner.nextInt();
                    System.out.print("Digite sua idade: ");
                    idade = scanner.nextInt();
                    System.out.print("Digite quantos acompanhantes: ");
                    acompanhantes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite seu nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite seu email: ");
                    email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    senha = scanner.nextLine();

                    ClienteModel c1 = new ClienteModel(cpf, idade, acompanhantes, nome, email, senha);

                    boolean cadastrado = clienteDAO.inserirCliente(c1);
                    if (cadastrado) {
                        System.out.println("----> Usuário cadastrado com sucesso");
                    } else {
                        System.out.println("----> Erro ao cadastrar");
                    }
                    break;
                    
                case 2:
                    for (ClienteModel c2: Cliente_DAO.buscarCliente()) {
                        System.out.println(c2.toString());
                    }
                    break;
                    
                case 3: 
                    System.out.print("Digite o ID do cliente que deseja atualizar: ");
                    id_cliente = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    System.out.print("Digite seu cpf: ");
                    cpf = scanner.nextInt();
                    System.out.print("Digite sua idade: ");
                    idade = scanner.nextInt();
                    System.out.print("Digite quantos acompanhantes: ");
                    acompanhantes = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite seu nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Digite seu email: ");
                    email = scanner.nextLine();
                    System.out.print("Digite sua senha: ");
                    senha = scanner.nextLine();
                    
                    ClienteModel c3 = new ClienteModel(id_cliente, cpf, idade, acompanhantes, nome, email, senha);
                    
                    Cliente_DAO.atualizarCliente(c3);
            		
            		break;
            		
            	case 4:
            		
            		System.out.println("Digite o ID que deseja remover: ");
            		id_cliente = scanner.nextInt();
            		scanner.nextLine();
            		
            		Cliente_DAO.deletarCliente(id_cliente);
            		
            		break;
            		
            	case 5:
            		
            		System.out.println("Digite o ID que deseja buscar: ");
            		id_cliente = scanner.nextInt();
            		scanner.nextLine();
            		
            		ClienteModel c4 = Cliente_DAO.buscarId(id_cliente);
            		System.out.println(c4.toString());
            		
            }
        } while (opcao != 0);

        System.out.println("Obrigado pela preferência");
    }
}
