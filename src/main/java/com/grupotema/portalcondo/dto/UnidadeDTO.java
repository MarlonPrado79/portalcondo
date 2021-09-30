package com.grupotema.portalcondo.dto;

import java.io.Serializable;

import com.grupotema.portalcondo.domain.Unidade;

public class UnidadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numero;

	public UnidadeDTO() {
	}

	public UnidadeDTO(Unidade obj) {
		id = obj.getId();
		numero = obj.getNumero();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
