package com.projeto.funancial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.funancial.model.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String>{
	Usuario findBy_id(ObjectId id);
}
