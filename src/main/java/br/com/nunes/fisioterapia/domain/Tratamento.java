package br.com.nunes.fisioterapia.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "tratamento")
public class Tratamento extends GenericDomain {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(nullable = false, length = 255)
  private String descricao;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Consulta consulta;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

}
