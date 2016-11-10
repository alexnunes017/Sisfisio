package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TR_ForcaMuscular extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(length = 50, nullable = false)
	private String musculos;
	@Column(length = 50, nullable = false)
	private String direita;
	@Column(length = 50, nullable = false)
	private String esquerda;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Traumatologica traumatologica;

	public TR_ForcaMuscular() {
		super();
	}

	public TR_ForcaMuscular(String musculos, String direita, String esquerda, Traumatologica traumatologica) {
		super();
		this.musculos = musculos;
		this.direita = direita;
		this.esquerda = esquerda;
		this.traumatologica = traumatologica;
	}

	public String getMusculos() {
		return musculos;
	}

	public void setMusculos(String musculos) {
		this.musculos = musculos;
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
