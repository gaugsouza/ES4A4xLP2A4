package com.projeto.funancial.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
	@Id 
	private ObjectId _id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
}
