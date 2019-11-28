package com.projeto.funancial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.projeto.funancial.model.Atributo;

/**
 * A interface <code>AtributoRepository</code> � utilizada para representar as opera��es CRUD 
 * (Create, Retrieve, Update and Delete) relativas � collection atributo da interface 
 * <code>org.springframework.data.mongodb.repository.MongoRepository</code>.
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 **/

public interface AtributoRepository extends MongoRepository<Atributo, String>{
	Atributo findBy_id(ObjectId id);
}
