package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TR_Adm extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(length = 50, nullable = false)
	private String movimento;
	@Column(length = 50, nullable = false)
	private String direita;
	@Column(length = 50, nullable = false)
	private String esquerda;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Traumatologica traumatologica;

	public TR_Adm() {
		super();
	}

	public TR_Adm(String movimento, String direita, String esquerda, Traumatologica traumatologica) {
		super();
		this.movimento = movimento;
		this.direita = direita;
		this.esquerda = esquerda;
		this.traumatologica = traumatologica;
	}

	public String getMovimento() {
		return movimento;
	}

	public void setMovimento(String movimento) {
		this.movimento = movimento;
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
