package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="traumatologica")
public class Traumatologica extends GenericDomain {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(length = 50, nullable = false)
  private String qp;

  @Column(length = 50, nullable = false)
  private String hpma;

  @Column(length = 50, nullable = false)
  private String examesComplemetares;

  @Column(nullable = false)
  private Boolean osteossintese;

  @Column(nullable = false)
  private Boolean diu;

  @Column(nullable = false)
  private Boolean marcaPasso;

  @Column(length = 50, nullable = false)
  private String eva;

  @Column(length = 50, nullable = false)
  private String patologiasAssociadas;

  @Column(length = 50, nullable = false)
  private String exameFisico;

  @Column(length = 10, nullable = false)
  private String pa;

  @Column(length = 10, nullable = false)
  private String fc;

  @Column(length = 50, nullable = false)
  private String inspecao;

  @Column(length = 50, nullable = false)
  private String palpacao;

  @Column(length = 50, nullable = false)
  private String discrepancia;

  @Column(length = 50, nullable = false)
  private String diagnostico;

  @OneToOne
  @JoinColumn(nullable = false)
  private Consulta consulta;

  public Traumatologica() {
    super();
  }

  public Traumatologica(String qp, String hpma, String examesComplemetares, Boolean osteossintese,
      Boolean diu, Boolean marcaPasso, String eva, String patologiasAssociadas, String exameFisico,
      String pa, String fc, String inspecao, String palpacao, String discrepancia,
      String diagnostico, Consulta consulta) {
    super();
    this.qp = qp;
    this.hpma = hpma;
    this.examesComplemetares = examesComplemetares;
    this.osteossintese = osteossintese;
    this.diu = diu;
    this.marcaPasso = marcaPasso;
    this.eva = eva;
    this.patologiasAssociadas = patologiasAssociadas;
    this.exameFisico = exameFisico;
    this.pa = pa;
    this.fc = fc;
    this.inspecao = inspecao;
    this.palpacao = palpacao;
    this.discrepancia = discrepancia;
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

  public String getExamesComplemetares() {
    return examesComplemetares;
  }

  public void setExamesComplemetares(String examesComplemetares) {
    this.examesComplemetares = examesComplemetares;
  }

  public Boolean getOsteossintese() {
    return osteossintese;
  }

  public void setOsteossintese(Boolean osteossintese) {
    this.osteossintese = osteossintese;
  }

  public Boolean getDiu() {
    return diu;
  }

  public void setDiu(Boolean diu) {
    this.diu = diu;
  }

  public Boolean getMarcaPasso() {
    return marcaPasso;
  }

  public void setMarcaPasso(Boolean marcaPasso) {
    this.marcaPasso = marcaPasso;
  }

  public String getEva() {
    return eva;
  }

  public void setEva(String eva) {
    this.eva = eva;
  }

  public String getPatologiasAssociadas() {
    return patologiasAssociadas;
  }

  public void setPatologiasAssociadas(String patologiasAssociadas) {
    this.patologiasAssociadas = patologiasAssociadas;
  }

  public String getExameFisico() {
    return exameFisico;
  }

  public void setExameFisico(String exameFisico) {
    this.exameFisico = exameFisico;
  }

  public String getPa() {
    return pa;
  }

  public void setPa(String pa) {
    this.pa = pa;
  }

  public String getFc() {
    return fc;
  }

  public void setFc(String fc) {
    this.fc = fc;
  }

  public String getInspecao() {
    return inspecao;
  }

  public void setInspecao(String inspecao) {
    this.inspecao = inspecao;
  }

  public String getPalpacao() {
    return palpacao;
  }

  public void setPalpacao(String palpacao) {
    this.palpacao = palpacao;
  }

  public String getDiscrepancia() {
    return discrepancia;
  }

  public void setDiscrepancia(String discrepancia) {
    this.discrepancia = discrepancia;
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
