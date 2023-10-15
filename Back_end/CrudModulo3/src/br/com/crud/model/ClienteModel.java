package br.com.crud.model;

import java.util.ArrayList;

public class ClienteModel {
	
	private int id_cliente;
	private int cpf;
	private int idade;
	private int acompanhantes;
	private String nome;
	private String email;
	private String senha;
	public ClienteModel() {
	}

	public ClienteModel(int cpf, int idade, int acompanhantes, String nome, String email, String senha) {
		this.cpf = cpf;
		this.idade = idade;
		this.acompanhantes = acompanhantes;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public ClienteModel(int id_cliente, int cpf, int idade, int acompanhantes, String nome, String email, String senha) {
		this.id_cliente = id_cliente;
		this.cpf = cpf;
		this.idade = idade;
		this.acompanhantes = acompanhantes;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}


	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(int acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "ClienteModel [id_cliente=" + id_cliente + ", cpf=" + cpf + ", idade=" + idade + ", acompanhantes="
				+ acompanhantes + ", nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}

	
	
}
	
	