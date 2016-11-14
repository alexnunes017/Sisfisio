package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.sql.Connection;
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

import br.com.nunes.fisioterapia.dao.FisioterapeutaDAO;
import br.com.nunes.fisioterapia.dao.PessoaDAO;
import br.com.nunes.fisioterapia.domain.Fisioterapeuta;
import br.com.nunes.fisioterapia.domain.Pessoa;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FisioterapeutaBean implements Serializable {

  private Fisioterapeuta fisioterapeuta;
  private List<Fisioterapeuta> fisioterapeutas;
  private List<Pessoa> pessoas;

  public Fisioterapeuta getFisioterapeuta() {
    return fisioterapeuta;
  }

  public void setFisioterapeuta(Fisioterapeuta fisioterapeuta) {
    this.fisioterapeuta = fisioterapeuta;
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

  @PostConstruct
  public void listar() {
    try {
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      fisioterapeutas = fisioterapeutaDAO.listar();
      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoas = pessoaDAO.listarTipo("tipo", 'F');

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar o pessoas");
      e.printStackTrace();
    }
  }

  public void novo() {
    try {
      fisioterapeuta = new Fisioterapeuta();
      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoas = pessoaDAO.listarTipo("tipo", 'F');

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar um novo fisioterapeuta");
      e.printStackTrace();
    }
  }

  public void salvar() {
    try {
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      fisioterapeutaDAO.salvar(fisioterapeuta);
      novo();
      listar();
      Messages.addGlobalInfo("Fisioterapeuta salvo com sucesso!");

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o fisioterapeuta");
      e.printStackTrace();
    }
  }

  public void excluir(ActionEvent event) {
    try {

      fisioterapeuta = (Fisioterapeuta) event.getComponent().getAttributes()
          .get("fisioterapeutaSelecionado");
      FisioterapeutaDAO fisioterapeutaDAO = new FisioterapeutaDAO();
      fisioterapeutaDAO.excluir(fisioterapeuta);
      listar();
      Messages.addGlobalInfo("Fisioterapeuta excluido com sucesso!");
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir o fisioterapeuta");
      e.printStackTrace();
    }
  }

  public void editar(ActionEvent event) {
    fisioterapeuta = (Fisioterapeuta) event.getComponent().getAttributes()
        .get("fisioterapeutaSelecionado");

  }

  public void imprimir() {
    try {
      DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
      Map<String, Object> filtros = tabela.getFilters();

      String nomePessoa = (String) filtros.get("nomePessoa");
      String crefitoFisioterapeuta = (String) filtros.get("sigla");

      String caminho = Faces.getRealPath("/resources/reports/rel_Fisioterapeutas.jasper");

      Map<String, Object> parametros = new HashMap<>();

      if (nomePessoa == null) {
        parametros.put("nomePessoa", "%%");
      } else {
        parametros.put("nomePessoa", "%" + nomePessoa + "%");
      }
      if (crefitoFisioterapeuta == null) {
        parametros.put("crefitoFisioterapeuta", "%%");
      } else {
        parametros.put("crefitoFisioterapeuta", "%" + crefitoFisioterapeuta + "%");
      }

      Connection conexao = HibernateUtil.getConexao();

      JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
      JasperViewer viewer = new JasperViewer(relatorio, false);
      if (relatorio.getAnchorIndexes().isEmpty()) {
        System.out.println("Sem Dados");
      } else {

        viewer.setTitle("Relátorio de Fisioterapeutas(s)");
        viewer.setVisible(true);
        viewer.toFront();
      }

    } catch (JRException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
      erro.printStackTrace();
    }
  }
}
