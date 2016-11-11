package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="medico")
public class Medico extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1003971773686619162L;

	@Column(length = 14, nullable = false)
	private String crm;

	@Column(length = 50, nullable = false)
	private String nome;

	public Medico() {
		super();
	}

	public Medico(String crm, String nome) {
		super();
		this.crm = crm;
		this.nome = nome;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
