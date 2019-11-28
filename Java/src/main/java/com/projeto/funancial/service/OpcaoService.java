package com.projeto.funancial.service;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.projeto.funancial.model.Opcao;
import com.projeto.funancial.repository.OpcaoRepository;

/**
 * A classe <code>OpcaoService</code> � respons�vel por manipular as opera��es CRUD 
 * (Create, Retrieve, Update and Delete) relativas ao reposit�rio <code>OpcaoRepository</code>
 *
 * @author guilhermeguis@outlook.com
 * @version 1.0
 * @since JDK1.8
 */
public class OpcaoService {
	private OpcaoRepository opcaoRepository;
	
    public OpcaoService(OpcaoRepository opcaoRepository) {
    	this.opcaoRepository = opcaoRepository;
    }
    
    /**
     * Encontra todas as op��es da collection no banco.
     *
     * @return List<Opcao> - Todas as op��es encontradas.
     */
    public List<Opcao> findAll(){
    	List<Opcao> opcoes = new ArrayList<>();
        this.opcaoRepository.findAll().forEach(opcoes :: add);
        
        return opcoes;
    }
    
    /**
     * Encontra uma op��o por seu Id.
     *
     * @param ObjectId _id - A identifica��o da op��o
     * @return Opcao - A op��o, se existir
     */
    public Opcao findBy_Id(ObjectId id) {
    	return opcaoRepository.findBy_id(id);
    }
}
