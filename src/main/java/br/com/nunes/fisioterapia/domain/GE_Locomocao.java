package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GE_Locomocao extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(length = 1, nullable = false)
	private Integer cadeiraDeRodas;

	@Column(length = 1, nullable = false)
	private Integer marcha;

	@Column(length = 1, nullable = false)
	private Integer tipoDeMarcha;

	@Column(length = 1, nullable = false)
	private Integer disturbioTrofico;

	@Column(length = 1, nullable = false)
	private Integer pele;

	@Column(length = 1, nullable = false)
	private Integer escaras;

	@Column(length = 1, nullable = false)
	private Integer humor;

	@Column(length = 1, nullable = false)
	private Integer orientacaoEspacial;

	@Column(length = 1, nullable = false)
	private Integer memoriaAntiga;

	@Column(length = 1, nullable = false)
	private Integer capacidade;

	@Column(length = 1, nullable = false)
	private Integer memoriaAtual;

	@Column(length = 1, nullable = false)
	private Integer fala;

	@Column(length = 1, nullable = false)
	private Integer visao;

	@Column(length = 1, nullable = false)
	private Integer audicao;
	
	@Column(length = 1, nullable = false)
	private Integer avds;

	@Column(length = 200, nullable = false)
	private String observacao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Geriatrica geriatrica;

	public Integer getCadeiraDeRodas() {
		return cadeiraDeRodas;
	}

	public void setCadeiraDeRodas(Integer cadeiraDeRodas) {
		this.cadeiraDeRodas = cadeiraDeRodas;
	}

	public Integer getMarcha() {
		return marcha;
	}

	public void setMarcha(Integer marcha) {
		this.marcha = marcha;
	}

	public Integer getTipoDeMarcha() {
		return tipoDeMarcha;
	}

	public void setTipoDeMarcha(Integer tipoDeMarcha) {
		this.tipoDeMarcha = tipoDeMarcha;
	}

	public Integer getDisturbioTrofico() {
		return disturbioTrofico;
	}

	public void setDisturbioTrofico(Integer disturbioTrofico) {
		this.disturbioTrofico = disturbioTrofico;
	}

	public Integer getPele() {
		return pele;
	}

	public void setPele(Integer pele) {
		this.pele = pele;
	}

	public Integer getEscaras() {
		return escaras;
	}

	public void setEscaras(Integer escaras) {
		this.escaras = escaras;
	}

	public Integer getHumor() {
		return humor;
	}

	public void setHumor(Integer humor) {
		this.humor = humor;
	}

	public Integer getOrientacaoEspacial() {
		return orientacaoEspacial;
	}

	public void setOrientacaoEspacial(Integer orientacaoEspacial) {
		this.orientacaoEspacial = orientacaoEspacial;
	}

	public Integer getMemoriaAntiga() {
		return memoriaAntiga;
	}

	public void setMemoriaAntiga(Integer memoriaAntiga) {
		this.memoriaAntiga = memoriaAntiga;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getMemoriaAtual() {
		return memoriaAtual;
	}

	public void setMemoriaAtual(Integer memoriaAtual) {
		this.memoriaAtual = memoriaAtual;
	}

	public Integer getFala() {
		return fala;
	}

	public void setFala(Integer fala) {
		this.fala = fala;
	}

	public Integer getVisao() {
		return visao;
	}

	public void setVisao(Integer visao) {
		this.visao = visao;
	}

	public Integer getAudicao() {
		return audicao;
	}

	public void setAudicao(Integer audicao) {
		this.audicao = audicao;
	}

	public Integer getAvds() {
		return avds;
	}

	public void setAvds(Integer avds) {
		this.avds = avds;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Geriatrica getGeriatrica() {
		return geriatrica;
	}

	public void setGeriatrica(Geriatrica geriatrica) {
		this.geriatrica = geriatrica;
	}

}
