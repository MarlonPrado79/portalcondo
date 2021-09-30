package com.grupotema.portalcondo.dto;

import java.io.Serializable;

import com.grupotema.portalcondo.domain.Acesso;
import com.grupotema.portalcondo.domain.Propriedade;
import com.grupotema.portalcondo.domain.Usuario;

public class AcessoDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer nivel;
	private Usuario usuario;
	private Propriedade propriedade;
	
	public AcessoDTO() {
	}
	
	public AcessoDTO(Acesso obj) {
		id = obj.getId();
		nivel = obj.getNivel();
		usuario = obj.getUsuario();
		propriedade = obj.getPropriedade();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Propriedade getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}
}
