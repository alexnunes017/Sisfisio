package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NE_Indice extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 1, nullable = false)
	private Integer alimentacao;

	@Column(length = 1, nullable = false)
	private Integer asseio;

	@Column(length = 1, nullable = false)
	private Integer evacuacao;

	@Column(length = 1, nullable = false)
	private Integer miccao;

	@Column(length = 1, nullable = false)
	private Integer vestir;

	@Column(length = 1, nullable = false)
	private Integer tranferencia;

	@Column(length = 1, nullable = false)
	private Integer toalet;

	@Column(length = 1, nullable = false)
	private Integer mobilidade;

	@Column(length = 1, nullable = false)
	private Integer escadas;

	@Column(length = 1, nullable = false)
	private Integer banho;

	@Column(length = 1, nullable = true)
	private Integer total;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Neurologica neurologica;

	public Integer getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(Integer alimentacao) {
		this.alimentacao = alimentacao;
	}

	public Integer getAsseio() {
		return asseio;
	}

	public void setAsseio(Integer asseio) {
		this.asseio = asseio;
	}

	public Integer getEvacuacao() {
		return evacuacao;
	}

	public void setEvacuacao(Integer evacuacao) {
		this.evacuacao = evacuacao;
	}

	public Integer getMiccao() {
		return miccao;
	}

	public void setMiccao(Integer miccao) {
		this.miccao = miccao;
	}

	public Integer getVestir() {
		return vestir;
	}

	public void setVestir(Integer vestir) {
		this.vestir = vestir;
	}

	public Integer getTranferencia() {
		return tranferencia;
	}

	public void setTranferencia(Integer tranferencia) {
		this.tranferencia = tranferencia;
	}

	public Integer getToalet() {
		return toalet;
	}

	public void setToalet(Integer toalet) {
		this.toalet = toalet;
	}

	public Integer getMobilidade() {
		return mobilidade;
	}

	public void setMobilidade(Integer mobilidade) {
		this.mobilidade = mobilidade;
	}

	public Integer getEscadas() {
		return escadas;
	}

	public void setEscadas(Integer escadas) {
		this.escadas = escadas;
	}

	public Integer getBanho() {
		return banho;
	}

	public void setBanho(Integer banho) {
		this.banho = banho;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Neurologica getNeurologica() {
		return neurologica;
	}

	public void setNeurologica(Neurologica neurologica) {
		this.neurologica = neurologica;
	}
	
	
	

}
