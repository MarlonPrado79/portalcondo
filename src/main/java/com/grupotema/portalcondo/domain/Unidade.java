package com.grupotema.portalcondo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Unidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String numero;
	
	@ManyToOne  
	@JoinColumn(name="condominio_id")
	private Condominio condominio;
	
	/*@OneToMany(mappedBy="proprietario")
	private Proprietario proprietario;*/
	
	public Unidade() {
		
	}

	public Unidade(Integer id, String numero, Condominio condominio) {
		super();
		this.id = id;
		this.numero = numero;
		this.condominio = condominio;
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

	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}
	
	
}
