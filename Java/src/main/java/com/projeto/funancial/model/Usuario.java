package com.projeto.funancial.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
	@Id 
	private ObjectId _id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
}
