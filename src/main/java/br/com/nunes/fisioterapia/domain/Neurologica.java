package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="neurologica")
public class Neurologica extends GenericDomain {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(length = 50, nullable = false)
	private String qp;

	@Column(length = 50, nullable = false)
	private String hpma;

	@Column(length = 50, nullable = false)
	private String af;

	@Column(length = 5, nullable = false)
	private Double pa;

	@Column(length = 5, nullable = false)
	private Double fc;

	@Column(length = 5, nullable = false)
	private Double fr;

	@Column(length = 50, nullable = false)
	private String dor;

	@Column(length = 50, nullable = false)
	private String eva;

	@Column(length = 50, nullable = false)
	private String diagnostico;

	@OneToOne
	@JoinColumn(nullable = false)
	private Consulta consulta;

	public Neurologica() {
		super();
	}

	public Neurologica(String qp, String hpma, String af, Double pa, Double fc, Double fr, String dor, String eva,
			String diagnostico, Consulta consulta) {
		super();
		this.qp = qp;
		this.hpma = hpma;
		this.af = af;
		this.pa = pa;
		this.fc = fc;
		this.fr = fr;
		this.dor = dor;
		this.eva = eva;
		this.diagnostico = diagnostico;
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

	public String getAf() {
		return af;
	}

	public void setAf(String af) {
		this.af = af;
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

	public String getDor() {
		return dor;
	}

	public void setDor(String dor) {
		this.dor = dor;
	}

	public String getEva() {
		return eva;
	}

	public void setEva(String eva) {
		this.eva = eva;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

}
