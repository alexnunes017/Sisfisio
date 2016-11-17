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

import br.com.nunes.fisioterapia.dao.EstadoDAO;
import br.com.nunes.fisioterapia.domain.Estado;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

  private Estado estado;
  private List<Estado> estados;

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

  @PostConstruct
  public void listar() {
    try {
      EstadoDAO estadoDAO = new EstadoDAO();
      estados = estadoDAO.listar();
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar o estados");
      e.printStackTrace();
    }
  }

  public void novo() {
    estado = new Estado();
  }

  public void salvar() {
    try {
      EstadoDAO estadoDAO = new EstadoDAO();
      estadoDAO.merge(estado);
      novo();
      listar();
      Messages.addGlobalInfo("Estado salvo com sucesso!");

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o estado");
      e.printStackTrace();
    }
  }

  public void excluir(ActionEvent event) {
    try {
      estado = (Estado) event.getComponent().getAttributes().get("estadoSelecionado");
      EstadoDAO estadoDAO = new EstadoDAO();
      estadoDAO.excluir(estado);
      listar();
      Messages.addGlobalInfo("Estado excluido com sucesso!");
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado");
      e.printStackTrace();
    }
  }

  public void editar(ActionEvent event) {
    estado = (Estado) event.getComponent().getAttributes().get("estadoSelecionado");

  }

  public void imprimir() {
    try {
      DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
      Map<String, Object> filtros = tabela.getFilters();

      String nomeEstado = (String) filtros.get("nome");
      String siglaEstado = (String) filtros.get("sigla");

      String caminho = Faces.getRealPath("/resources/reports/rel_Estados.jasper");

      String caminhoBanner = Faces.getRealPath("/resources/images/banner2.jpeg");

      Map<String, Object> parametros = new HashMap<>();

      parametros.put("CAMINHO_BANNER", caminhoBanner);

      if (nomeEstado == null) {
        parametros.put("nomeEstado", "%%");
      } else {
        parametros.put("nomeEstado", "%" + nomeEstado + "%");
      }
      if (siglaEstado == null) {
        parametros.put("siglaEstado", "%%");
      } else {
        parametros.put("siglaEstado", "%" + siglaEstado + "%");
      }

      Connection conexao = HibernateUtil.getConexao();

      JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
      JasperViewer viewer = new JasperViewer(relatorio, false);
      if (relatorio.getAnchorIndexes().isEmpty()) {
        System.out.println("Sem Dados");
      } else {

        viewer.setTitle("Relátorio de Estado(s)");
        viewer.setVisible(true);
        viewer.toFront();
      }
      ;
      // JasperPrintManager.printReport(relatorio, true);

    } catch (JRException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
      erro.printStackTrace();
    }
  }
}
