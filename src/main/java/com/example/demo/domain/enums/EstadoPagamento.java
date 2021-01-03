package com.example.demo.domain.enums;

public enum EstadoPagamento {
	PENDENTE(0,"Pendente"),QUITADO(1,"Quitado"),CANCELADO(2,"Cancelado");
	private int id;
	private String descricao;
	private EstadoPagamento(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public static EstadoPagamento toEnum(Integer id) {
		if(id == null) {
			return null;
		}
		for(EstadoPagamento x: EstadoPagamento.values()) {
			if(x.getId().equals(id)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido: "+ id);
	}
}
