package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="tr_testesespeciais")
public class TR_TestesEspeciais extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(length = 50, nullable = false)
	private String testeEspecial;
	@Column(length = 50, nullable = false)
	private String direita;
	@Column(length = 50, nullable = false)
	private String esquerda;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Traumatologica traumatologica;

	public TR_TestesEspeciais() {
		super();
	}

	public TR_TestesEspeciais(String testeEspecial, String direita, String esquerda, Traumatologica traumatologica) {
		super();
		this.testeEspecial = testeEspecial;
		this.direita = direita;
		this.esquerda = esquerda;
		this.traumatologica = traumatologica;
	}

	public String getTesteEspecial() {
		return testeEspecial;
	}

	public void setTesteEspecial(String testeEspecial) {
		this.testeEspecial = testeEspecial;
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
