package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="cidade")
public class Cidade extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2210198045507520006L;

	@Column(length = 50, nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Estado estado;

	public Cidade() {
		super();
	}

	public Cidade(String nome, Estado estado) {
		super();
		this.nome = nome;
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
