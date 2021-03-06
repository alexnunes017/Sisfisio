package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.nunes.fisioterapia.dao.CidadeDAO;
import br.com.nunes.fisioterapia.dao.EstadoDAO;
import br.com.nunes.fisioterapia.dao.PessoaDAO;
import br.com.nunes.fisioterapia.domain.Cidade;
import br.com.nunes.fisioterapia.domain.Estado;
import br.com.nunes.fisioterapia.domain.Pessoa;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {
  private Pessoa pessoa;
  private List<Pessoa> pessoas;

  private Estado estado;
  private List<Estado> estados;

  private List<Cidade> cidades;

  public Pessoa getPessoa() {
    return pessoa;
  }

  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }

  public List<Pessoa> getPessoas() {
    return pessoas;
  }

  public void setPessoas(List<Pessoa> pessoas) {
    this.pessoas = pessoas;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public List<Estado> getEstados() {
    return estados;
  }

  public void setEstados(List<Estado> estados) {
    this.estados = estados;
  }

  public List<Cidade> getCidades() {
    return cidades;
  }

  public void setCidades(List<Cidade> cidades) {
    this.cidades = cidades;
  }

  @PostConstruct
  public void listar() {
    try {
      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoas = pessoaDAO.listar("nome");
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
      erro.printStackTrace();
    }
  }

  public void novo() {
    try {
      pessoa = new Pessoa();

      estado = new Estado();

      EstadoDAO estadoDAO = new EstadoDAO();
      estados = estadoDAO.listar("nome");

      cidades = new ArrayList<>();
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
      erro.printStackTrace();
    }
  }

  public void editar(ActionEvent evento) {
    try {
      pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");

      estado = pessoa.getCidade().getEstado();

      EstadoDAO estadoDAO = new EstadoDAO();
      estados = estadoDAO.listar("nome");

      CidadeDAO cidadeDAO = new CidadeDAO();
      cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar selecionar uma pessoa");
    }
  }

  public void salvar() {
    try {
      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoaDAO.merge(pessoa);

      pessoas = pessoaDAO.listar("nome");

      pessoa = new Pessoa();

      estado = new Estado();

      EstadoDAO estadoDAO = new EstadoDAO();
      estados = estadoDAO.listar("nome");

      cidades = new ArrayList<>();

      Messages.addGlobalInfo("Pessoa salva com sucesso");
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar a pessoa");
      erro.printStackTrace();
    }
  }

  public void excluir(ActionEvent evento) {
    try {
      pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionado");

      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoaDAO.excluir(pessoa);
      listar();
      Messages.addGlobalInfo("Pessoa excluido com sucesso!");
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir a pessoa");
      e.printStackTrace();
    }
  }

  public void popular() {
    try {
      if (estado != null) {
        CidadeDAO cidadeDAO = new CidadeDAO();
        cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
      } else {
        cidades = new ArrayList<>();
      }
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar filtrar as cidades");
      erro.printStackTrace();
    }
  }

  public void imprimir() {
    try {
      DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
      Map<String, Object> filtros = tabela.getFilters();

      String nomePessoa = (String) filtros.get("nomePessoa");
      String cpfPessoa = (String) filtros.get("cpfPessoa");
      String tipoPessoa = (String) filtros.get("tipoPessoa");

      String caminho = Faces.getRealPath("/resources/reports/rel_Pacientes.jasper");
      String caminhoBanner = Faces.getRealPath("/resources/images/banner2.jpeg");

      Map<String, Object> parametros = new HashMap<>();
      parametros.put("CAMINHO_BANNER", caminhoBanner);

      if (nomePessoa == null) {
        parametros.put("nomePessoa", "%%");
      } else {
        parametros.put("nomePessoa", "%" + nomePessoa + "%");
      }
      if (cpfPessoa == null) {
        parametros.put("cpfPessoa", "%%");
      } else {
        parametros.put("cpfPessoa", "%" + cpfPessoa + "%");
      }
      if (tipoPessoa == null) {
        parametros.put("tipoPessoa", "%%");
      } else {
        parametros.put("tipoPessoa", "%" + tipoPessoa + "%");
      }

      Connection conexao = HibernateUtil.getConexao();

      JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
      JasperViewer viewer = new JasperViewer(relatorio, false);
      if (relatorio.getAnchorIndexes().isEmpty()) {
        System.out.println("Sem Dados");
      } else {

        viewer.setTitle("Relátorio de Pessoa(s)");
        viewer.setVisible(true);
        viewer.toFront();
      }
      ;

    } catch (JRException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
      erro.printStackTrace();
    }
  }
}