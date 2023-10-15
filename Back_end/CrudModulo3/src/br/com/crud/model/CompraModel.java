package br.com.crud.model;

public class CompraModel {
		
	
	private String data_compra;
	private int id_compra;
	private String metodo_pagamento;
	private double total_compra;
	
	ClienteModel c1;
	PassagemModel p1;
	
	public CompraModel() {
	}

	public CompraModel(  String data_compra,  int id_compra, ClienteModel c1, PassagemModel p1,String metodo_pagamento, Double total_compra) {
		this.data_compra = data_compra;
		this.id_compra = id_compra;
		this.c1 = c1;
		this.p1 = p1;
		this.metodo_pagamento = metodo_pagamento;
		this.total_compra = valorFinalViagem(p1.getPreço(), metodo_pagamento);
	}

	public CompraModel(String data_compra, ClienteModel c1, PassagemModel p1, String metodo_pagamento, Double total_compra) {
		this.data_compra = data_compra;
		this.c1 = c1;
		this.p1 = p1;
		this.metodo_pagamento = metodo_pagamento;
		this.total_compra = valorFinalViagem(p1.getPreço(), metodo_pagamento);
	}

	public int getId() {
		return id_compra;
	}


	public void setId(int id) {
		this.id_compra = id;
	}

	public String getData_compra() {
		return data_compra;
	}

	public void setData_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	

	public double getTotal_compra() {
		return total_compra;
	}

	public void setTotal_compra(double total_compra) {
		this.total_compra = total_compra;
	}

	public ClienteModel getC1() {
		return c1;
	}

	public void setC1(ClienteModel c1) {
		this.c1 = c1;
	}

	public PassagemModel getP1() {
		return p1;
	}

	public void setP1(PassagemModel p1) {
		this.p1 = p1;
	}
	
	public String getMetodo_pagamento() {
		return metodo_pagamento;
	}

	public void setMetodo_pagamento(String metodo_pagamento) {
		this.metodo_pagamento = metodo_pagamento;
	}
	
	public double valorFinalViagem(Double preço, String forma_pagamento) {
	    if ("dinheiro".equalsIgnoreCase(forma_pagamento)) {
	        this.total_compra = preço * 0.85;
	    } else {
	        this.total_compra = preço;
	    }
	    return this.total_compra;
	}

	@Override
	public String toString() {
		return "CompraModel [data_compra=" + data_compra + ", id_compra=" + id_compra + ", metodo_pagamento="
				+ metodo_pagamento + ", total_compra=" + total_compra + ", c1=" + c1 + ", p1=" + p1 + "]";
	}
	
	
	
	

}
