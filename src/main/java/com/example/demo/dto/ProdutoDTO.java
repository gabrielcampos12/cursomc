package com.example.demo.dto;

import java.io.Serializable;

import com.example.demo.domain.Produto;

public class ProdutoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nome;
	private Double preco;
	
	public ProdutoDTO() {
		
	}

	public ProdutoDTO(Produto produto) {
		super();
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	

}
