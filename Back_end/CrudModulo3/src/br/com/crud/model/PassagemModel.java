package br.com.crud.model;

public class PassagemModel {
	
	private int id_passagem;
	private String cidade;
	private String data_passagem;
	private Double preço;
	private String categoria;
	
	
	
	public PassagemModel() {
	
	}
	

	public PassagemModel(int id_passagem, String cidade, String data_passagem, Double preço, String categoria) {
		this.id_passagem = id_passagem;
		this.cidade = cidade;
		this.data_passagem = data_passagem;
		this.preço = preço;
		this.categoria = categoria;
	}
	
	public PassagemModel(String cidade, String data_passagem, Double preço, String categoria) {
		this.cidade = cidade;
		this.data_passagem = data_passagem;
		this.preço = preço;
		this.categoria = categoria;
	}


	public int getId_passagem() {
		return id_passagem;
	}
	public void setId_passagem(int id_passagem) {
		this.id_passagem = id_passagem;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getData_passagem() {
		return data_passagem;
	}


	public void setData_passagem(String data_passagem) {
		this.data_passagem = data_passagem;
	}


	public Double getPreço() {
		return preço;
	}
	public void setPreço(Double preço) {
		this.preço = preço;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "PassagemModel [id_passagem=" + id_passagem + ", cidade=" + cidade + ", data_passagem=" + data_passagem
				+ ", preço=" + preço + ", categoria=" + categoria + "]";
	}
	
	

	
	
}