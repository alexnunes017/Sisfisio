package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ge_exame")
public class GE_Exame extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(length = 1, nullable = false)
	private Integer tonus;

	@Column(length = 1, nullable = false)
	private Integer trofismo;

	@Column(length = 1, nullable = false)
	private Integer arcoMovimento;

	@Column(length = 1, nullable = false)
	private Integer escapula;

	@Column(length = 1, nullable = false)
	private Integer ombros;

	@Column(length = 1, nullable = false)
	private Integer cotovelo;

	@Column(length = 1, nullable = false)
	private Integer punho;

	@Column(length = 1, nullable = false)
	private Integer dedos;

	@Column(length = 1, nullable = false)
	private Integer tronco;

	@Column(length = 1, nullable = false)
	private Integer quadril;

	@Column(length = 1, nullable = false)
	private Integer joelho;

	@Column(length = 1, nullable = false)
	private Integer tornozelo;

	@Column(length = 1, nullable = false)
	private Integer face;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Geriatrica geriatrica;

	public Integer getTonus() {
		return tonus;
	}

	public void setTonus(Integer tonus) {
		this.tonus = tonus;
	}

	public Integer getTrofismo() {
		return trofismo;
	}

	public void setTrofismo(Integer trofismo) {
		this.trofismo = trofismo;
	}

	public Integer getArcoMovimento() {
		return arcoMovimento;
	}

	public void setArcoMovimento(Integer arcoMovimento) {
		this.arcoMovimento = arcoMovimento;
	}

	public Integer getEscapula() {
		return escapula;
	}

	public void setEscapula(Integer escapula) {
		this.escapula = escapula;
	}

	public Integer getOmbros() {
		return ombros;
	}

	public void setOmbros(Integer ombros) {
		this.ombros = ombros;
	}

	public Integer getCotovelo() {
		return cotovelo;
	}

	public void setCotovelo(Integer cotovelo) {
		this.cotovelo = cotovelo;
	}

	public Integer getPunho() {
		return punho;
	}

	public void setPunho(Integer punho) {
		this.punho = punho;
	}

	public Integer getDedos() {
		return dedos;
	}

	public void setDedos(Integer dedos) {
		this.dedos = dedos;
	}

	public Integer getTronco() {
		return tronco;
	}

	public void setTronco(Integer tronco) {
		this.tronco = tronco;
	}

	public Integer getQuadril() {
		return quadril;
	}

	public void setQuadril(Integer quadril) {
		this.quadril = quadril;
	}

	public Integer getJoelho() {
		return joelho;
	}

	public void setJoelho(Integer joelho) {
		this.joelho = joelho;
	}

	public Integer getTornozelo() {
		return tornozelo;
	}

	public void setTornozelo(Integer tornozelo) {
		this.tornozelo = tornozelo;
	}

	public Integer getFace() {
		return face;
	}

	public void setFace(Integer face) {
		this.face = face;
	}

	public Geriatrica getGeriatrica() {
		return geriatrica;
	}

	public void setGeriatrica(Geriatrica geriatrica) {
		this.geriatrica = geriatrica;
	}


	
	
}
