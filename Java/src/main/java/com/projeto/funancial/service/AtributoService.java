package com.projeto.funancial.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.projeto.funancial.model.Atributo;
import com.projeto.funancial.repository.AtributoRepository;

/**
 * A classe <code>AtributoService</code> é responsável por manipular as operações CRUD 
 * (Create, Retrieve, Update and Delete) relativas ao repositório <code>AtributoRepository</code>
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
public class AtributoService {
	private AtributoRepository atributoRepository;
	
    public AtributoService(AtributoRepository atributoRepository) {
    	this.atributoRepository = atributoRepository;
    }
    
    /**
     * Encontra todos os atributos da collection no banco.
     *
     * @return List<Opcao> - Todos os atributos encontrados.
     */
    public List<Atributo> findAll(){
    	List<Atributo> atributos = new ArrayList<>();
        this.atributoRepository.findAll().forEach(atributos :: add);
        
        return atributos;
    }
    
    /**
     * Encontra um atributo por seu Id.
     *
     * @param ObjectId _id - A identificação do atributo
     * @return Atributo - O atributo, se existir
     */
    public Atributo findBy_Id(ObjectId id) {
    	return atributoRepository.findBy_id(id);
    }

    /**
     * Salva/atualiza um atributo no banco de dados
     *
     * @param Atributo atributo  - O atributo que será salvo/atualizado no banco de dados
     * @return Atributo - O atributo salvo.
     */
    public Atributo save(Atributo atributo) {   	
    	return atributoRepository.save(atributo);
    }
}