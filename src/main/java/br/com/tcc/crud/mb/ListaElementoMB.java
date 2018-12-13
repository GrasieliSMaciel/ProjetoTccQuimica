package br.com.tcc.crud.mb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.tcc.crud.model.Elemento;
import br.com.tcc.crud.service.ElementoService;
import br.com.tcc.crud.util.FacesUtil;

@Named
@ViewScoped
public class ListaElementoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ElementoService elementoService;
	
	private List<Elemento> elementos = new ArrayList<>();
	
	private List<Elemento> elementosSelecionados = new ArrayList<>();
	
	private Elemento elemento = new Elemento();
	
	private Long idResultElemento;
	
	private int idElemento;
	
	private String teste1;
	
	private String nome;
	
	private Float unidade = (float) 1;
	
	private Float resultadoMolar;
	
	private Float resultadoMolarTotal = (float) 0;
	
	private List<Float> listaResultados = new ArrayList<>();
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Init lista elemento MB");
		elementos = elementoService.listAll();
		System.out.println("Inicializou!!");
		teste1 = "Grasi";
		
	}
	
	public void busca(Long id) {
		
		System.out.println("Id" + id);
		
		elemento = elementoService.porId(id);

		System.out.println(elemento == null ? "Vazio!" : "Passou das busca");

		System.out.println(elemento == null ? "" :"Elemento: " + elemento);
		
		if(elemento == null) {
			mensagem("Elemento não cadastrado!");
		}
		
	}
	
	public void limpar() {
		resultadoMolar = (float) 0;
	}
	
	public void calcular() {
		
		for(int i = 0; i <listaResultados.size(); i++) {
			
			System.out.println("valor: " + listaResultados.get(i));
			resultadoMolarTotal = resultadoMolarTotal + listaResultados.get(i);
			
			resultadoMolar = resultadoMolarTotal;
		}
		
	}
	
	public void calcula(Long id) {
		
//		if(unidade == null) {
//			mensagem("Digite a unidade do elemento!");
//		}
		
		System.out.println("Id" + id);
		
		elemento = elementoService.porId(id);
		
		if(elemento == null) {
			mensagem("Elemento não cadastrado!");
			return;
		}
//		else {
			
			if(unidade == null) {
				float pesoAtomico;
				pesoAtomico = elemento.getPropriedadesFisicas().getPesoAtomico();
				resultadoMolar = resultadoMolar + pesoAtomico * 1;
				listaResultados.add(resultadoMolar);
				
			}else {
				float pesoAtomico;
				pesoAtomico = elemento.getPropriedadesFisicas().getPesoAtomico();
				resultadoMolar = pesoAtomico * unidade;
				listaResultados.add(resultadoMolar);
			}
			
			unidade = (float) 1;
//		}
		
	}
	
    public void mensagem(String msg) {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage(null, new FacesMessage("Atenção",  "" + msg) );
    }
	
    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
    }
     
    public void warn() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Watch out for PrimeFaces."));
    }
     
    public void error() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
    }
     
    public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }
	
	public void excluirSelecionados() {
		
		System.out.println("Excluir selecionados");
		
		for (Elemento elemento : elementosSelecionados) {
			elementoService.excluir(elemento);
			elementos.remove(elemento);
		}
		
		FacesUtil.addInfoMessage("Elemento(s) excluï¿½dos com sucesso!");
	}
	
	

	public ElementoService getElementoService() {
		System.out.println("Get elemento");
		return elementoService;
	}

	public void setElementoService(ElementoService elementoService) {
		this.elementoService = elementoService;
	}

	public List<Elemento> getElementos() {
		return elementos;
	}

	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}

	public List<Elemento> getElementosSelecionados() {
		return elementosSelecionados;
	}

	public void setElementosSelecionados(List<Elemento> elementosSelecionados) {
		this.elementosSelecionados = elementosSelecionados;
	}

	public String getTeste1() {
		return teste1;
	}

	public void setTeste1(String teste1) {
		this.teste1 = teste1;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public int getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(int idElemento) {
		this.idElemento = idElemento;
	}

	public Long getIdResultElemento() {
		return idResultElemento;
	}

	public void setIdResultElemento(Long idResultElemento) {
		this.idResultElemento = idResultElemento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getUnidade() {
		return unidade;
	}

	public void setUnidade(Float unidade) {
		this.unidade = unidade;
	}

	public Float getResultadoMolar() {
		return resultadoMolar;
	}

	public void setResultadoMolar(Float resultadoMolar) {
		this.resultadoMolar = resultadoMolar;
	}

	public Float getResultadoMolarTotal() {
		return resultadoMolarTotal;
	}

	public void setResultadoMolarTotal(Float resultadoMolarTotal) {
		this.resultadoMolarTotal = resultadoMolarTotal;
	}

	public List<Float> getListaResultados() {
		return listaResultados;
	}

	public void setListaResultados(List<Float> listaResultados) {
		this.listaResultados = listaResultados;
	}

	
	
}
