package br.com.tcc.crud.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.tcc.crud.dao.SubstanciaDAO;
import br.com.tcc.crud.model.Substancia;
import br.com.tcc.crud.util.Transacional;

public class SubstanciaService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SubstanciaDAO substanciaDAO;	
	
	
	@Transacional
	public void salvar(Substancia substancia) {
		if (substancia.isInclusao()) {
			substancia.setCriacao(new Date());
		}
		
		if (substancia.isEdicao()) {
			substancia.setEdicao(new Date());
		}
		
		substanciaDAO.salvar(substancia);
	}
	
	@Transacional
	public void excluir(Substancia substancia) {
		substanciaDAO.excluir(substancia);
	}
	
	
	public List<Substancia> listAll() {
		System.out.println("List all taref service");
		return substanciaDAO.listAll();
	}
	
	public Substancia porId(Long id) {
		return substanciaDAO.porId(id);
	}

}
