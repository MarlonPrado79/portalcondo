package com.grupotema.portalcondo.dto;

import java.io.Serializable;

import com.grupotema.portalcondo.domain.Propriedade;

public class PropriedadeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id; 

	public PropriedadeDTO() {
	}
	
	public PropriedadeDTO(Propriedade obj) {
		id = obj.getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
