package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ne_tonus")
public class NE_Tonus extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 1, nullable = false)
	private Integer tonus;

	@Column(length = 1, nullable = false)
	private Integer escalaMsd;

	@Column(length = 1, nullable = false)
	private Integer escalaMse;

	@Column(length = 1, nullable = false)
	private Integer escalaMid;

	@Column(length = 1, nullable = false)
	private Integer escalaMie;

	@Column(length = 100, nullable = false)
	private String adm;

	@Column(length = 1, nullable = false)
	private Integer biciptalD;

	@Column(length = 1, nullable = false)
	private Integer biciptalE;

	@Column(length = 1, nullable = false)
	private Integer triciptalD;

	@Column(length = 1, nullable = false)
	private Integer triciptalE;

	@Column(length = 1, nullable = false)
	private Integer aquileuD;

	@Column(length = 1, nullable = false)
	private Integer aquileuE;

	@Column(length = 1, nullable = false)
	private Integer patelarD;

	@Column(length = 1, nullable = false)
	private Integer patelarE;

	@Column(length = 1, nullable = false)
	private Integer cutaneoPlanarD;

	@Column(length = 1, nullable = false)
	private Integer cutaneoPlanarE;

	@Column(length = 1, nullable = false)
	private Integer movimentoMsd;

	@Column(length = 1, nullable = false)
	private Integer pincaFinaD;

	@Column(length = 1, nullable = false)
	private Integer movimentoMse;

	@Column(length = 1, nullable = false)
	private Integer pincaFinaE;

	@Column(length = 1, nullable = false)
	private Integer movimentoMid;

	@Column(length = 1, nullable = false)
	private Integer movimentoMie;

	@Column(length = 1, nullable = false)
	private Integer ddDld;

	@Column(length = 1, nullable = false)
	private Integer ddDle;

	@Column(length = 1, nullable = false)
	private Integer ddDv;

	@Column(length = 1, nullable = false)
	private Integer ddSentado;

	@Column(length = 1, nullable = false)
	private Integer ddGato;

	@Column(length = 1, nullable = false)
	private Integer gatoAjoelhado;

	@Column(length = 1, nullable = false)
	private Integer AjoelhadoSemi;

	@Column(length = 1, nullable = false)
	private Integer semiEmpe;

	@Column(length = 1, nullable = false)
	private Integer sentadoEmpe;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadeMsd;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadeMid;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadeMse;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadeMie;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadetroncoD;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadetroncoE;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadeEtronco;

	@Column(length = 1, nullable = false)
	private Integer sensibilidadeEromberg;

	@Column(length = 1, nullable = false)
	private Integer marcha;

	@Column(length = 200, nullable = false)
	private String obs;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Neurologica neurologica;

	public Integer getTonus() {
		return tonus;
	}

	public void setTonus(Integer tonus) {
		this.tonus = tonus;
	}

	public Integer getEscalaMsd() {
		return escalaMsd;
	}

	public void setEscalaMsd(Integer escalaMsd) {
		this.escalaMsd = escalaMsd;
	}

	public Integer getEscalaMse() {
		return escalaMse;
	}

	public void setEscalaMse(Integer escalaMse) {
		this.escalaMse = escalaMse;
	}

	public Integer getEscalaMid() {
		return escalaMid;
	}

	public void setEscalaMid(Integer escalaMid) {
		this.escalaMid = escalaMid;
	}

	public Integer getEscalaMie() {
		return escalaMie;
	}

	public void setEscalaMie(Integer escalaMie) {
		this.escalaMie = escalaMie;
	}

	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public Integer getBiciptalD() {
		return biciptalD;
	}

	public void setBiciptalD(Integer biciptalD) {
		this.biciptalD = biciptalD;
	}

	public Integer getBiciptalE() {
		return biciptalE;
	}

	public void setBiciptalE(Integer biciptalE) {
		this.biciptalE = biciptalE;
	}

	public Integer getTriciptalD() {
		return triciptalD;
	}

	public void setTriciptalD(Integer triciptalD) {
		this.triciptalD = triciptalD;
	}

	public Integer getTriciptalE() {
		return triciptalE;
	}

	public void setTriciptalE(Integer triciptalE) {
		this.triciptalE = triciptalE;
	}

	public Integer getAquileuD() {
		return aquileuD;
	}

	public void setAquileuD(Integer aquileuD) {
		this.aquileuD = aquileuD;
	}

	public Integer getAquileuE() {
		return aquileuE;
	}

	public void setAquileuE(Integer aquileuE) {
		this.aquileuE = aquileuE;
	}

	public Integer getPatelarD() {
		return patelarD;
	}

	public void setPatelarD(Integer patelarD) {
		this.patelarD = patelarD;
	}

	public Integer getPatelarE() {
		return patelarE;
	}

	public void setPatelarE(Integer patelarE) {
		this.patelarE = patelarE;
	}

	public Integer getCutaneoPlanarD() {
		return cutaneoPlanarD;
	}

	public void setCutaneoPlanarD(Integer cutaneoPlanarD) {
		this.cutaneoPlanarD = cutaneoPlanarD;
	}

	public Integer getCutaneoPlanarE() {
		return cutaneoPlanarE;
	}

	public void setCutaneoPlanarE(Integer cutaneoPlanarE) {
		this.cutaneoPlanarE = cutaneoPlanarE;
	}

	public Integer getMovimentoMsd() {
		return movimentoMsd;
	}

	public void setMovimentoMsd(Integer movimentoMsd) {
		this.movimentoMsd = movimentoMsd;
	}

	public Integer getPincaFinaD() {
		return pincaFinaD;
	}

	public void setPincaFinaD(Integer pincaFinaD) {
		this.pincaFinaD = pincaFinaD;
	}

	public Integer getMovimentoMse() {
		return movimentoMse;
	}

	public void setMovimentoMse(Integer movimentoMse) {
		this.movimentoMse = movimentoMse;
	}

	public Integer getPincaFinaE() {
		return pincaFinaE;
	}

	public void setPincaFinaE(Integer pincaFinaE) {
		this.pincaFinaE = pincaFinaE;
	}

	public Integer getMovimentoMid() {
		return movimentoMid;
	}

	public void setMovimentoMid(Integer movimentoMid) {
		this.movimentoMid = movimentoMid;
	}

	public Integer getMovimentoMie() {
		return movimentoMie;
	}

	public void setMovimentoMie(Integer movimentoMie) {
		this.movimentoMie = movimentoMie;
	}

	public Integer getDdDld() {
		return ddDld;
	}

	public void setDdDld(Integer ddDld) {
		this.ddDld = ddDld;
	}

	public Integer getDdDle() {
		return ddDle;
	}

	public void setDdDle(Integer ddDle) {
		this.ddDle = ddDle;
	}

	public Integer getDdDv() {
		return ddDv;
	}

	public void setDdDv(Integer ddDv) {
		this.ddDv = ddDv;
	}

	public Integer getDdSentado() {
		return ddSentado;
	}

	public void setDdSentado(Integer ddSentado) {
		this.ddSentado = ddSentado;
	}

	public Integer getDdGato() {
		return ddGato;
	}

	public void setDdGato(Integer ddGato) {
		this.ddGato = ddGato;
	}

	public Integer getGatoAjoelhado() {
		return gatoAjoelhado;
	}

	public void setGatoAjoelhado(Integer gatoAjoelhado) {
		this.gatoAjoelhado = gatoAjoelhado;
	}

	public Integer getAjoelhadoSemi() {
		return AjoelhadoSemi;
	}

	public void setAjoelhadoSemi(Integer ajoelhadoSemi) {
		AjoelhadoSemi = ajoelhadoSemi;
	}

	public Integer getSemiEmpe() {
		return semiEmpe;
	}

	public void setSemiEmpe(Integer semiEmpe) {
		this.semiEmpe = semiEmpe;
	}

	public Integer getSentadoEmpe() {
		return sentadoEmpe;
	}

	public void setSentadoEmpe(Integer sentadoEmpe) {
		this.sentadoEmpe = sentadoEmpe;
	}

	public Integer getSensibilidadeMsd() {
		return sensibilidadeMsd;
	}

	public void setSensibilidadeMsd(Integer sensibilidadeMsd) {
		this.sensibilidadeMsd = sensibilidadeMsd;
	}

	public Integer getSensibilidadeMid() {
		return sensibilidadeMid;
	}

	public void setSensibilidadeMid(Integer sensibilidadeMid) {
		this.sensibilidadeMid = sensibilidadeMid;
	}

	public Integer getSensibilidadeMse() {
		return sensibilidadeMse;
	}

	public void setSensibilidadeMse(Integer sensibilidadeMse) {
		this.sensibilidadeMse = sensibilidadeMse;
	}

	public Integer getSensibilidadeMie() {
		return sensibilidadeMie;
	}

	public void setSensibilidadeMie(Integer sensibilidadeMie) {
		this.sensibilidadeMie = sensibilidadeMie;
	}

	public Integer getSensibilidadetroncoD() {
		return sensibilidadetroncoD;
	}

	public void setSensibilidadetroncoD(Integer sensibilidadetroncoD) {
		this.sensibilidadetroncoD = sensibilidadetroncoD;
	}

	public Integer getSensibilidadetroncoE() {
		return sensibilidadetroncoE;
	}

	public void setSensibilidadetroncoE(Integer sensibilidadetroncoE) {
		this.sensibilidadetroncoE = sensibilidadetroncoE;
	}

	public Integer getSensibilidadeEtronco() {
		return sensibilidadeEtronco;
	}

	public void setSensibilidadeEtronco(Integer sensibilidadeEtronco) {
		this.sensibilidadeEtronco = sensibilidadeEtronco;
	}

	public Integer getSensibilidadeEromberg() {
		return sensibilidadeEromberg;
	}

	public void setSensibilidadeEromberg(Integer sensibilidadeEromberg) {
		this.sensibilidadeEromberg = sensibilidadeEromberg;
	}

	public Integer getMarcha() {
		return marcha;
	}

	public void setMarcha(Integer marcha) {
		this.marcha = marcha;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Neurologica getNeurologica() {
		return neurologica;
	}

	public void setNeurologica(Neurologica neurologica) {
		this.neurologica = neurologica;
	}

}
