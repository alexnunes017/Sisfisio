package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NE_SensibilidadeProfunda extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(length = 1, nullable = false)
	private Integer MsdPolegar;

	@Column(length = 1, nullable = false)
	private Integer MsdPunho;

	@Column(length = 1, nullable = false)
	private Integer MsdCotovelo;

	@Column(length = 1, nullable = false)
	private Integer MsdOmbro;

	@Column(length = 1, nullable = false)
	private Integer MidHalux;

	@Column(length = 1, nullable = false)
	private Integer MidTornozelo;

	@Column(length = 1, nullable = false)
	private Integer MidJoelho;

	@Column(length = 1, nullable = false)
	private Integer MidQuadril;

	@Column(length = 1, nullable = false)
	private Integer MsePolegar;

	@Column(length = 1, nullable = false)
	private Integer MsePunho;

	@Column(length = 1, nullable = false)
	private Integer MseCotovelo;

	@Column(length = 1, nullable = false)
	private Integer MseOmbro;

	@Column(length = 1, nullable = false)
	private Integer MieHalux;

	@Column(length = 1, nullable = false)
	private Integer MieTornozelo;

	@Column(length = 1, nullable = false)
	private Integer MieJoelho;

	@Column(length = 1, nullable = false)
	private Integer MieQuadril;

	@Column(length = 1, nullable = false)
	private Integer profundaTronco;

	@Column(length = 1, nullable = false)
	private Integer profundaRomberg;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Neurologica neurologica;

	public Integer getMsdPolegar() {
		return MsdPolegar;
	}

	public void setMsdPolegar(Integer msdPolegar) {
		MsdPolegar = msdPolegar;
	}

	public Integer getMsdPunho() {
		return MsdPunho;
	}

	public void setMsdPunho(Integer msdPunho) {
		MsdPunho = msdPunho;
	}

	public Integer getMsdCotovelo() {
		return MsdCotovelo;
	}

	public void setMsdCotovelo(Integer msdCotovelo) {
		MsdCotovelo = msdCotovelo;
	}

	public Integer getMsdOmbro() {
		return MsdOmbro;
	}

	public void setMsdOmbro(Integer msdOmbro) {
		MsdOmbro = msdOmbro;
	}

	public Integer getMidHalux() {
		return MidHalux;
	}

	public void setMidHalux(Integer midHalux) {
		MidHalux = midHalux;
	}

	public Integer getMidTornozelo() {
		return MidTornozelo;
	}

	public void setMidTornozelo(Integer midTornozelo) {
		MidTornozelo = midTornozelo;
	}

	public Integer getMidJoelho() {
		return MidJoelho;
	}

	public void setMidJoelho(Integer midJoelho) {
		MidJoelho = midJoelho;
	}

	public Integer getMidQuadril() {
		return MidQuadril;
	}

	public void setMidQuadril(Integer midQuadril) {
		MidQuadril = midQuadril;
	}

	public Integer getMsePolegar() {
		return MsePolegar;
	}

	public void setMsePolegar(Integer msePolegar) {
		MsePolegar = msePolegar;
	}

	public Integer getMsePunho() {
		return MsePunho;
	}

	public void setMsePunho(Integer msePunho) {
		MsePunho = msePunho;
	}

	public Integer getMseCotovelo() {
		return MseCotovelo;
	}

	public void setMseCotovelo(Integer mseCotovelo) {
		MseCotovelo = mseCotovelo;
	}

	public Integer getMseOmbro() {
		return MseOmbro;
	}

	public void setMseOmbro(Integer mseOmbro) {
		MseOmbro = mseOmbro;
	}

	public Integer getMieHalux() {
		return MieHalux;
	}

	public void setMieHalux(Integer mieHalux) {
		MieHalux = mieHalux;
	}

	public Integer getMieTornozelo() {
		return MieTornozelo;
	}

	public void setMieTornozelo(Integer mieTornozelo) {
		MieTornozelo = mieTornozelo;
	}

	public Integer getMieJoelho() {
		return MieJoelho;
	}

	public void setMieJoelho(Integer mieJoelho) {
		MieJoelho = mieJoelho;
	}

	public Integer getMieQuadril() {
		return MieQuadril;
	}

	public void setMieQuadril(Integer mieQuadril) {
		MieQuadril = mieQuadril;
	}

	public Integer getProfundaTronco() {
		return profundaTronco;
	}

	public void setProfundaTronco(Integer profundaTronco) {
		this.profundaTronco = profundaTronco;
	}

	public Integer getProfundaRomberg() {
		return profundaRomberg;
	}

	public void setProfundaRomberg(Integer profundaRomberg) {
		this.profundaRomberg = profundaRomberg;
	}

	public Neurologica getNeurologica() {
		return neurologica;
	}

	public void setNeurologica(Neurologica neurologica) {
		this.neurologica = neurologica;
	}

}
