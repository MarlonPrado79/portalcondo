package com.grupotema.portalcondo.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.grupotema.portalcondo.domain.Usuario;
import com.grupotema.portalcondo.services.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id; 
	
	@NotEmpty(message="Preenchimento obritatório")
	@Length(min=5, max=60, message="O tamanho deve ser entre 5 e 60 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obritatório")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obritatório")
	@Length(min=5, max=60, message="O tamanho deve ser entre 5 e 60 caracteres")
	private String login;
	
	@NotEmpty(message="Preenchimento obritatório")
	@Length(min=5, max=60, message="O tamanho deve ser entre 5 e 60 caracteres")
	private String senha;

	public UsuarioDTO(){
	}

	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
		login = obj.getLogin();
		senha = obj.getSenha();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
	
