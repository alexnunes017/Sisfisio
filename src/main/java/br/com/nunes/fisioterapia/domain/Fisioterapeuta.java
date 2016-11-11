package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="fisioterapeuta")
public class Fisioterapeuta extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8283045879957258930L;

	@Column(length = 12, nullable = false)
	private String crefito;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public String getCrefito() {
		return crefito;
	}

	public void setCrefito(String crefito) {
		this.crefito = crefito;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
