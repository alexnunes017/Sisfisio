package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Tratamento extends GenericDomain {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(nullable = false, length = 255)
  private String tratamento;

  @OneToOne
  @JoinColumn(nullable = false)
  private Consulta consulta;

  public String getTratamento() {
    return tratamento;
  }

  public void setTratamento(String tratamento) {
    this.tratamento = tratamento;
  }

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

}
