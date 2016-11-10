package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TR_Sensibilidade extends GenericDomain {

	@Column(length = 50, nullable = false)
	private String dermatomos;
	@Column(length = 50, nullable = false)
	private String direita;
	@Column(length = 50, nullable = false)
	private String esquerda;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Traumatologica traumatologica;

	public TR_Sensibilidade() {
		super();
	}

	public TR_Sensibilidade(String dermatomos, String direita, String esquerda, Traumatologica traumatologica) {
		super();
		this.dermatomos = dermatomos;
		this.direita = direita;
		this.esquerda = esquerda;
		this.traumatologica = traumatologica;
	}

	public String getDermatomos() {
		return dermatomos;
	}

	public void setDermatomos(String dermatomos) {
		this.dermatomos = dermatomos;
	}

	public String getDireita() {
		return direita;
	}

	public void setDireita(String direita) {
		this.direita = direita;
	}

	public String getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(String esquerda) {
		this.esquerda = esquerda;
	}

	public Traumatologica getTraumatologica() {
		return traumatologica;
	}

	public void setTraumatologica(Traumatologica traumatologica) {
		this.traumatologica = traumatologica;
	}

}
