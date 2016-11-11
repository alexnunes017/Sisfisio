package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.nunes.fisioterapia.dao.ConsultaDAO;
import br.com.nunes.fisioterapia.dao.FisioterapeutaDAO;
import br.com.nunes.fisioterapia.dao.MedicoDAO;
import br.com.nunes.fisioterapia.dao.PessoaDAO;
import br.com.nunes.fisioterapia.dao.TratamentoDAO;
import br.com.nunes.fisioterapia.dao.UsuarioDAO;
import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.Fisioterapeuta;
import br.com.nunes.fisioterapia.domain.Medico;
import br.com.nunes.fisioterapia.domain.Pessoa;
import br.com.nunes.fisioterapia.domain.Tratamento;
import br.com.nunes.fisioterapia.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TratamentoBean implements Serializable {

  private Consulta consulta;
  private Consulta retorno;
  private Tratamento tratamento;
  private List<Consulta> consultas;
  private List<Tratamento> tratamentos;
  private List<Fisioterapeuta> fisioterapeutas;
  private List<Pessoa> pessoas;
  private List<Usuario> usuarios;
  private List<Medico> medicos;

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public Consulta getRetorno() {
    return retorno;
  }

  public void setRetorno(Consulta retorno) {
    this.retorno = retorno;
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

  public Tratamento getTratamento() {
    return tratamento;
  }

  public void setTratamento(Tratamento tratamento) {
    this.tratamento = tratamento;
  }

  public List<Tratamento> getTratamentos() {
    return tratamentos;
  }

  public void setTratamentos(List<Tratamento> tratamentos) {
    this.tratamentos = tratamentos;
  }

  public void novo() {
    try {
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      PessoaDAO pessoaDAO = new PessoaDAO();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      MedicoDAO medicoDAO = new MedicoDAO();

  //    consulta = new Consulta();
      tratamento = new Tratamento();
      fisioterapeutas = fisioterapeutaDAO.listar();
      pessoas = pessoaDAO.listarTipo("tipo", 'P');
      usuarios = usuarioDAO.listar();
      medicos = medicoDAO.listar();

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova consulta");
      e.printStackTrace();
    }
  }

  public void salvar() {

    try {
      TratamentoDAO tratamentoDAO = new TratamentoDAO();
      ConsultaDAO consultaDAO = new ConsultaDAO();
      consulta.setStatus('R');
      consultaDAO.merge(consulta);
      tratamento.setConsulta(consulta);

      tratamentoDAO.salvar(tratamento);

      novo();
      listar();

      Messages.addGlobalInfo("Tratamento realizado com sucesso!");
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Tratamento");
      e.printStackTrace();
    }
  }

  @PostConstruct
  public void listar() {

    Character tipo[] = { 'T' };
    Character tipos[] = { 'M', 'C', 'R' };
    try {
      ConsultaDAO consultaDAO = new ConsultaDAO();
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      PessoaDAO pessoaDAO = new PessoaDAO();
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      MedicoDAO medicoDAO = new MedicoDAO();

      consulta = new Consulta();
      fisioterapeutas = fisioterapeutaDAO.listar();
      pessoas = pessoaDAO.listarTipo("tipo", 'P');
      usuarios = usuarioDAO.listar();
      medicos = medicoDAO.listar();
      consultas = consultaDAO.listarTiposDuplo("tipo", tipo, "status", tipos);

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar as consultas");
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
    novo();

  }

}
