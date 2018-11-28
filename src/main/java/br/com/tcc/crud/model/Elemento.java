package br.com.tcc.crud.model;


import java.awt.TextArea;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Elemento implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	
	private String links;
	
	private String nomeLatim;
	
	private String nomeIngles;
	
	private String cas;
	
	private Short camadasEletronicas;
	
	private String simbolo;
	
	private String origemNome;
	
	private String serieQuimica;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Descoberta descoberta;
	
	@OneToOne
	private PropriedadesAtomicas propriedadesAtomicas;
	
	@OneToOne
	private PropriedadesEletromagneticas propriedadesEletromagneticas;
	
	@OneToOne
	private PropriedadesDiversas propriedadesDiversas;
	
	@OneToOne
	private PropriedadesFisicas propriedadesFisicas;
	
	@OneToOne
	private CelulaCristalina celulaCristalina;
	
	
	public boolean isInclusao() {
		return getId() == null ? true : false;
	}
	
	public boolean isEdicao() {
		return !isInclusao();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeLatim() {
		return nomeLatim;
	}

	public void setNomeLatim(String nomeLatim) {
		this.nomeLatim = nomeLatim;
	}

	public String getNomeIngles() {
		return nomeIngles;
	}

	public void setNomeIngles(String nomeIngles) {
		this.nomeIngles = nomeIngles;
	}

		
	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public Short getCamadasEletronicas() {
		return camadasEletronicas;
	}

	public void setCamadasEletronicas(Short camadasEletronicas) {
		this.camadasEletronicas = camadasEletronicas;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getOrigemNome() {
		return origemNome;
	}

	public void setOrigemNome(String origemNome) {
		this.origemNome = origemNome;
	}

	public String getSerieQuimica() {
		return serieQuimica;
	}

	public void setSerieQuimica(String serieQuimica) {
		this.serieQuimica = serieQuimica;
	}

	public Descoberta getDescoberta() {
		return descoberta;
	}

	public void setDescoberta(Descoberta descoberta) {
		this.descoberta = descoberta;
	}

	public PropriedadesAtomicas getPropriedadesAtomicas() {
		return propriedadesAtomicas;
	}

	public void setPropriedadesAtomicas(PropriedadesAtomicas propriedadesAtomicas) {
		this.propriedadesAtomicas = propriedadesAtomicas;
	}

	public PropriedadesEletromagneticas getPropriedadesEletromagneticas() {
		return propriedadesEletromagneticas;
	}

	public void setPropriedadesEletromagneticas(PropriedadesEletromagneticas propriedadesEletromagneticas) {
		this.propriedadesEletromagneticas = propriedadesEletromagneticas;
	}

	public PropriedadesDiversas getPropriedadesDiversas() {
		return propriedadesDiversas;
	}

	public void setPropriedadesDiversas(PropriedadesDiversas propriedadesDiversas) {
		this.propriedadesDiversas = propriedadesDiversas;
	}

	public PropriedadesFisicas getPropriedadesFisicas() {
		return propriedadesFisicas;
	}

	public void setPropriedadesFisicas(PropriedadesFisicas propriedadesFisicas) {
		this.propriedadesFisicas = propriedadesFisicas;
	}

	public CelulaCristalina getCelulaCristalina() {
		return celulaCristalina;
	}

	public void setCelulaCristalina(CelulaCristalina celulaCristalina) {
		this.celulaCristalina = celulaCristalina;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}


	
	
	
//	@ManyToOne
//	@JoinColumn(nullable = false)
//	private Cidade cidade;

	

//	public Cidade getCidade() {
//		return cidade;
//	}
//
//	public void setCidade(Cidade cidade) {
//		this.cidade = cidade;
//	}
		
}
