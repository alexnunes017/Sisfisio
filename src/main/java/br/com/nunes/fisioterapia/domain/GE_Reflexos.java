package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ge_reflexos")
public class GE_Reflexos extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private Integer dolorosa;

	@Column(length = 1, nullable = false)
	private Integer tatil;

	@Column(length = 1, nullable = false)
	private Integer propioceptiva;

	@Column(length = 50, nullable = false)
	private String local;

	@Column(length = 50, nullable = false)
	private String tipo;

	@Column(length = 90, nullable = false)
	private String eva;

	@Column(length = 1, nullable = false)
	private Integer indexIndex;

	@Column(length = 1, nullable = false)
	private Integer indexNariz;

	@Column(length = 1, nullable = false)
	private Integer calcanharJoelho;

	@Column(length = 1, nullable = false)
	private Integer sentado;

	@Column(length = 1, nullable = false)
	private Integer romberg;

	@Column(length = 1, nullable = false)
	private Integer rombergSensibilizado;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Geriatrica geriatrica;

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

	public Integer getDolorosa() {
		return dolorosa;
	}

	public void setDolorosa(Integer dolorosa) {
		this.dolorosa = dolorosa;
	}

	public Integer getTatil() {
		return tatil;
	}

	public void setTatil(Integer tatil) {
		this.tatil = tatil;
	}

	public Integer getPropioceptiva() {
		return propioceptiva;
	}

	public void setPropioceptiva(Integer propioceptiva) {
		this.propioceptiva = propioceptiva;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEva() {
		return eva;
	}

	public void setEva(String eva) {
		this.eva = eva;
	}

	public Integer getIndexIndex() {
		return indexIndex;
	}

	public void setIndexIndex(Integer indexIndex) {
		this.indexIndex = indexIndex;
	}

	public Integer getIndexNariz() {
		return indexNariz;
	}

	public void setIndexNariz(Integer indexNariz) {
		this.indexNariz = indexNariz;
	}

	public Integer getCalcanharJoelho() {
		return calcanharJoelho;
	}

	public void setCalcanharJoelho(Integer calcanharJoelho) {
		this.calcanharJoelho = calcanharJoelho;
	}

	public Integer getSentado() {
		return sentado;
	}

	public void setSentado(Integer sentado) {
		this.sentado = sentado;
	}

	public Integer getRomberg() {
		return romberg;
	}

	public void setRomberg(Integer romberg) {
		this.romberg = romberg;
	}

	public Integer getRombergSensibilizado() {
		return rombergSensibilizado;
	}

	public void setRombergSensibilizado(Integer rombergSensibilizado) {
		this.rombergSensibilizado = rombergSensibilizado;
	}

	public Geriatrica getGeriatrica() {
		return geriatrica;
	}

	public void setGeriatrica(Geriatrica geriatrica) {
		this.geriatrica = geriatrica;
	}

}
