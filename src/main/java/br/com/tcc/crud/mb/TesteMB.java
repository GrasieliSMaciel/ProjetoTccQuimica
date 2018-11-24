package br.com.tcc.crud.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import br.com.tcc.crud.model.Tarefa;
import br.com.tcc.crud.service.TarefaService;

public class TesteMB implements Serializable{


	private static final long serialVersionUID = 1L;

	
	
	@Inject
	private TarefaService tarefaService;
	
	private List<Tarefa> tarefas = new ArrayList<>();
	
	
	@PostConstruct
	public void init() {
		tarefas = tarefaService.listAll();
	}
	

}
