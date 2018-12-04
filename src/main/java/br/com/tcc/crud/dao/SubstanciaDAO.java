package br.com.tcc.crud.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.tcc.crud.exception.NegocioException;
import br.com.tcc.crud.model.Substancia;

public class SubstanciaDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Substancia salvar(Substancia substancia) {
		return manager.merge(substancia);
	}
	
	public void excluir(Substancia substancia) {
		try {
			substancia = porId(substancia.getId());
			manager.remove(substancia);
			manager.flush();
			
		} catch (Exception e) {			
			throw new NegocioException("Substancia não pode ser excluída");
		}
	}

	public Substancia porId(Long id) {		
		return manager.find(Substancia.class, id);
	}
	
	public List<Substancia> listAll() {
		return manager.createNativeQuery("SELECT * FROM Substancia", Substancia.class).getResultList();
	}

}
