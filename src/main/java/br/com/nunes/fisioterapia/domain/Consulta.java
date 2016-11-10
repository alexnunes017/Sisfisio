package br.com.nunes.fisioterapia.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Consulta extends GenericDomain {

  /**
   * 
   */
  private static final long serialVersionUID = 5975626767064465706L;

  @Column(length = 100, nullable = false)
  private String motivo;

  @Column(length = 1, nullable = false)
  private Character status;

  @Column(length = 1, nullable = false)
  private Character tipo;

  @Temporal(TemporalType.TIME)
  private Date hora;

  @Temporal(TemporalType.DATE)
  private Date data;

  @Column(length = 250)
  private String diagnostico;


  @Column(length = 1, nullable = false)
  private Character avaliacao;

  @OneToOne
  @JoinColumn(nullable = false)
  private Fisioterapeuta fisioterapeuta;

  @OneToOne
  @JoinColumn(nullable = false)
  private Medico medico;

  @OneToOne
  @JoinColumn(nullable = false)
  private Pessoa pessoa;

  @OneToMany(mappedBy = "consulta", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Traumatologica> traumatologicas;

  @OneToMany(mappedBy = "consulta", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Neurologica> neurologicas;

  @OneToMany(mappedBy = "consulta", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Geriatrica> geriatricas;

  @OneToMany(mappedBy = "consulta", fetch = FetchType.EAGER)
  @Fetch(value = FetchMode.SUBSELECT)
  private List<Tratamento> tratamentos;

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public Character getStatus() {
    return status;
  }

  @Transient
  public String getStatusFormatado() {
    String statusFormatado = null;

    if (status == 'M') {
      statusFormatado = "Marcada";
    } else if (status == 'C') {
      statusFormatado = "Cancelada";
    } else if (status == 'R') {
      statusFormatado = "Realizada";
    }

    return statusFormatado;
  }

  public void setStatus(Character status) {
    this.status = status;
  }

  public Date getHora() {
    return hora;
  }

  public void setHora(Date hora) {
    this.hora = hora;
  }

  public Date getData() {
    return data;
  }

  public String getDataFormatada() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    String date;
    date = dateFormat.format(data);
    return date;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getDiagnostico() {
    return diagnostico;
  }

  public void setDiagnostico(String diagnostico) {
    this.diagnostico = diagnostico;
  }



  @Transient
  public String getTipoFormatado() {
    String tipoFormatado = null;

    if (tipo == 'A') {
      tipoFormatado = "Avaliação";
    } else if (tipo == 'T') {
      tipoFormatado = "Tratamento";
    }

    return tipoFormatado;
  }

  @Transient
  public String getAvaliacaoFormatado() {
    String avaliacaoFormatado = null;

    if (avaliacao == 'T') {
      avaliacaoFormatado = "Traumatologica";
    } else if (avaliacao == 'G') {
      avaliacaoFormatado = "Geriatrica";
    } else if (avaliacao == 'N') {
      avaliacaoFormatado = "Neurologica";
    } else if (avaliacao == 'D') {
      avaliacaoFormatado = "Diagnostico";
    }

    return avaliacaoFormatado;
  }

  public Character getTipo() {
    return tipo;
  }

  public void setTipo(Character tipo) {
    this.tipo = tipo;
  }

  public Fisioterapeuta getFisioterapeuta() {
    return fisioterapeuta;
  }

  public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
    this.fisioterapeuta = fisioterapeuta;
  }

  public Medico getMedico() {
    return medico;
  }

  public void setMedico(Medico medico) {
    this.medico = medico;
  }

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public Character getAvaliacao() {
    return avaliacao;
  }

  public void setAvaliacao(Character avaliacao) {
    this.avaliacao = avaliacao;
  }

  public List<Traumatologica> getTraumatologicas() {
    return traumatologicas;
  }

  public void setTraumatologicas(List<Traumatologica> traumatologicas) {
    this.traumatologicas = traumatologicas;
  }

  public List<Neurologica> getNeurologicas() {
    return neurologicas;
  }

  public void setNeurologicas(List<Neurologica> neurologicas) {
    this.neurologicas = neurologicas;
  }

  public List<Geriatrica> getGeriatricas() {
    return geriatricas;
  }

  public void setGeriatricas(List<Geriatrica> geriatricas) {
    this.geriatricas = geriatricas;
  }

  public List<Tratamento> getTratamentos() {
    return tratamentos;
  }

  public void setTratamentos(List<Tratamento> tratamentos) {
    this.tratamentos = tratamentos;
  }

}
