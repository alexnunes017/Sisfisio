package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.nunes.fisioterapia.dao.CidadeDAO;
import br.com.nunes.fisioterapia.dao.ConsultaDAO;
import br.com.nunes.fisioterapia.dao.EstadoDAO;
import br.com.nunes.fisioterapia.dao.FisioterapeutaDAO;
import br.com.nunes.fisioterapia.dao.MedicoDAO;
import br.com.nunes.fisioterapia.dao.PessoaDAO;
import br.com.nunes.fisioterapia.dao.UsuarioDAO;
import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.Estado;
import br.com.nunes.fisioterapia.domain.Fisioterapeuta;
import br.com.nunes.fisioterapia.domain.Medico;
import br.com.nunes.fisioterapia.domain.Pessoa;
import br.com.nunes.fisioterapia.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ConsultaBean implements Serializable {

  private Consulta consulta;
  private List<Consulta> consultas;
  private List<Fisioterapeuta> fisioterapeutas;
  private List<Pessoa> pessoas;
  private List<Usuario> usuarios;
  private List<Medico> medicos;
  private Boolean situacao;
  private Boolean situacaoConsulta;

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public void setConsultas(List<Consulta> consultas) {
    this.consultas = consultas;
  }

  public List<Fisioterapeuta> getFisioterapeutas() {
    return fisioterapeutas;
  }

  public void setFisioterapeutas(List<Fisioterapeuta> fisioterapeutas) {
    this.fisioterapeutas = fisioterapeutas;
  }

  public List<Pessoa> getPessoas() {
    return pessoas;
  }

  public void setPessoas(List<Pessoa> pessoas) {
    this.pessoas = pessoas;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public List<Medico> getMedicos() {
    return medicos;
  }

  public void setMedicos(List<Medico> medicos) {
    this.medicos = medicos;
  }

  public Boolean getSituacao() {
    return situacao;
  }

  public void setSituacao(Boolean situacao) {
    this.situacao = situacao;
  }

  public Boolean getSituacaoConsulta() {
    return situacaoConsulta;
  }

  public void setSituacaoConsulta(Boolean situacaoConsulta) {
    this.situacaoConsulta = situacaoConsulta;
  }

  public void salvar() {

    try {
      ConsultaDAO consultaDAO = new ConsultaDAO();

      if (consulta.getStatus() == null) {
        consulta.setStatus('M');
      } else if (!consulta.getStatus().equals('R') || !consulta.getStatus().equals('C')) {
        consulta.setStatus('M');
      }
      if (consulta.getAvaliacao() == null) {
        consulta.setAvaliacao('D');
      }

      consultaDAO.merge(consulta);

      novo();
      listar();

      Messages.addGlobalInfo("Consulta agendada com sucesso!");
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o consulta");
      e.printStackTrace();
    }
  }

  @PostConstruct
  public void listar() {
    try {
      ConsultaDAO consultaDAO = new ConsultaDAO();
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      PessoaDAO pessoaDAO = new PessoaDAO();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      MedicoDAO medicoDAO = new MedicoDAO();

      consultas = consultaDAO.listar();
      fisioterapeutas = fisioterapeutaDAO.listar();
      pessoas = pessoaDAO.listarTipo("tipo", 'P');
      usuarios = usuarioDAO.listar();
      medicos = medicoDAO.listar();
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar as consultas");
      e.printStackTrace();
    }
  }

  public void novo() {
    try {
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      PessoaDAO pessoaDAO = new PessoaDAO();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      MedicoDAO medicoDAO = new MedicoDAO();

      consulta = new Consulta();
      fisioterapeutas = fisioterapeutaDAO.listar();
      pessoas = pessoaDAO.listarTipo("tipo", 'P');
      usuarios = usuarioDAO.listar();
      medicos = medicoDAO.listar();

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova consulta");
      e.printStackTrace();
    }
  }

  public void excluir(ActionEvent event) {
    try {
      consulta = (Consulta) event.getComponent().getAttributes().get("consultaSelecionada");

      ConsultaDAO consultaDAO = new ConsultaDAO();
      if (consulta.getStatus().equals('M')) {
        consulta.setStatus('C');
        consultaDAO.merge(consulta);
        listar();
        Messages.addGlobalInfo("Consulta cancelada com sucesso!");

      } else {
        Messages.addGlobalWarn("Consulta  não pode ser cancelada!");
      }
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado");
      e.printStackTrace();
    }
  }

  public void editar(ActionEvent event) {
    consulta = (Consulta) event.getComponent().getAttributes().get("consultaSelecionada");
    consulta.getFisioterapeuta().getPessoa();
    consulta.getPessoa();
    consulta.getMedico();
  }

  public void mudar() {
    if (consulta.getTipo().equals('A')) {
      this.situacao = false;
    } else {
      this.situacao = true;
    }
  }

  public void mudarConsulta() {
    if (consulta.getStatus().equals('M')) {
      this.situacaoConsulta = false;
    } else {
      this.situacaoConsulta = true;
    }
  }

}
