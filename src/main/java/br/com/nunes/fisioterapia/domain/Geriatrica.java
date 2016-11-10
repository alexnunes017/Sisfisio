package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Geriatrica extends GenericDomain {

	/**
   * 
   */
  private static final long serialVersionUID = 1L;
  @Column(length = 50, nullable = false)
	private String qp;
	@Column(length = 50, nullable = false)
	private String hpma;
	@Column(length = 50, nullable = false)
	private String patologiasAssociadas;
	@Column(length = 50, nullable = false)
	private Double pa;
	@Column(length = 5, nullable = false)
	private Double fc;
	@Column(length = 5, nullable = false)
	private Double fr;
	@Column(length = 50, nullable = false)
	private String inspecao;
	@Column(length = 50, nullable = false)
	private String retracoes;
	@Column(length = 50, nullable = false)
	private String leito;
	@Column(length = 50, nullable = false)
	private String diagnostico;

	@OneToOne
	@JoinColumn(nullable = false)
	private Consulta consulta;

	public Geriatrica() {
		super();
	}

	public Geriatrica(String qp, String hpma, String patologiasAssociadas, Double pa, Double fc, Double fr,
			String inspecao, String retracoes, String leito, String diagnostico, Consulta consulta) {
		super();
		this.qp = qp;
		this.hpma = hpma;
		this.patologiasAssociadas = patologiasAssociadas;
		this.pa = pa;
		this.fc = fc;
		this.fr = fr;
		this.inspecao = inspecao;
		this.retracoes = retracoes;
		this.leito = leito;
		this.diagnostico = diagnostico;
		this.consulta = consulta;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public String getQp() {
		return qp;
	}

	public void setQp(String qp) {
		this.qp = qp;
	}

	public String getHpma() {
		return hpma;
	}

	public void setHpma(String hpma) {
		this.hpma = hpma;
	}

	public String getPatologiasAssociadas() {
		return patologiasAssociadas;
	}

	public void setPatologiasAssociadas(String patologiasAssociadas) {
		this.patologiasAssociadas = patologiasAssociadas;
	}

	public Double getPa() {
		return pa;
	}

	public void setPa(Double pa) {
		this.pa = pa;
	}

	public Double getFc() {
		return fc;
	}

	public void setFc(Double fc) {
		this.fc = fc;
	}

	public Double getFr() {
		return fr;
	}

	public void setFr(Double fr) {
		this.fr = fr;
	}

	public String getInspecao() {
		return inspecao;
	}

	public void setInspecao(String inspecao) {
		this.inspecao = inspecao;
	}

	public String getRetracoes() {
		return retracoes;
	}

	public void setRetracoes(String retracoes) {
		this.retracoes = retracoes;
	}

	public String getLeito() {
		return leito;
	}

	public void setLeito(String leito) {
		this.leito = leito;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }

}
