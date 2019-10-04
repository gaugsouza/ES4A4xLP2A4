package com.projeto.funancial.model;


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
	private @Id @GeneratedValue Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
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
	
	private Usuario() {}
	
	public Usuario(String nome, String sobrenome, String email, String senha) {
		setNome(nome);
		setSobrenome(sobrenome);
		setEmail(email);
		setSenha(senha);
	}
	
	
	//TODO: Forma de criptografar senha
	
	
	@Override
	public String toString() {
		return "Usuario{" +
			"id=" + id +
			", nome='" + nome + '\'' +
			", sobrenome='" + sobrenome + '\'' +
			", email='" + email + '\'' +
			", senha='" + senha + '\'' +
			'}';
	}
}
