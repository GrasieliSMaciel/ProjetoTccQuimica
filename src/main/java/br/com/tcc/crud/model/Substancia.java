package br.com.tcc.crud.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Substancia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	private String nome;
	
	private Integer quantidadeElemento;
	
	private BigDecimal mol;
	
	private String curiosidades;
	
	private BigDecimal molalidade;
	
	private BigDecimal molaridade;
	
	private BigDecimal massaMolar;
	
	private BigDecimal densidade;
	
	private String descricao;
	
	private Date criacao;
	

	private Date edicao;
	
	
//    @ManyToMany(cascade = { 
//            CascadeType.PERSIST, 
//            CascadeType.MERGE
//        })
//	
@ManyToMany
@JoinTable(name = "substancias_has_elementos",
joinColumns = {@JoinColumn(name = "substancias_id")},
inverseJoinColumns={@JoinColumn(name="elemento_id")})
private List<Elemento> elementosSubstancias = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Integer getQuantidadeElemento() {
		return quantidadeElemento;
	}

	public void setQuantidadeElemento(Integer quantidadeElemento) {
		this.quantidadeElemento = quantidadeElemento;
	}



	public BigDecimal getDensidade() {
		return densidade;
	}

	public void setDensidade(BigDecimal densidade) {
		this.densidade = densidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getEdicao() {
		return edicao;
	}

	public void setEdicao(Date edicao) {
		this.edicao = edicao;
	}

	public List<Elemento> getElementosSubstancias() {
		return elementosSubstancias;
	}

	public void setElementosSubstancias(List<Elemento> elementosSubstancias) {
		this.elementosSubstancias = elementosSubstancias;
	}
	
	

	public BigDecimal getMol() {
		return mol;
	}

	public void setMol(BigDecimal mol) {
		this.mol = mol;
	}

	public BigDecimal getMolalidade() {
		return molalidade;
	}

	public void setMolalidade(BigDecimal molalidade) {
		this.molalidade = molalidade;
	}

	public BigDecimal getMolaridade() {
		return molaridade;
	}

	public void setMolaridade(BigDecimal molaridade) {
		this.molaridade = molaridade;
	}

	public BigDecimal getMassaMolar() {
		return massaMolar;
	}

	public void setMassaMolar(BigDecimal massaMolar) {
		this.massaMolar = massaMolar;
	}
	
	

	public String getCuriosidades() {
		return curiosidades;
	}

	public void setCuriosidades(String curiosidades) {
		this.curiosidades = curiosidades;
	}

	public boolean isInclusao() {
		return getId() == null ? true : false;
	}
	
	public boolean isEdicao() {
		return !isInclusao();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Substancia other = (Substancia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
