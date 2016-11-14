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

import br.com.nunes.fisioterapia.dao.ConsultaDAO;
import br.com.nunes.fisioterapia.dao.GE_ExameDAO;
import br.com.nunes.fisioterapia.dao.GE_LocomocaoDAO;
import br.com.nunes.fisioterapia.dao.GE_ReflexosDAO;
import br.com.nunes.fisioterapia.dao.GeriatricaDAO;
import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.GE_Exame;
import br.com.nunes.fisioterapia.domain.GE_Locomocao;
import br.com.nunes.fisioterapia.domain.GE_Reflexos;
import br.com.nunes.fisioterapia.domain.Geriatrica;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class GeriatricaBean implements Serializable {

  private Geriatrica geriatrica;
  private Geriatrica retorno;
  private GE_Exame exame;
  private GE_Locomocao locomocao;
  private GE_Reflexos reflexos;
  private List<Geriatrica> geriatricas;
  private List<GE_Exame> exames;
  private List<GE_Locomocao> locomocaos;
  private List<GE_Reflexos> ge_Reflexos;
  private List<Consulta> consultas;
  private Consulta consulta;

  public Geriatrica getGeriatrica() {
    return geriatrica;
  }

  public void setGeriatrica(Geriatrica geriatrica) {
    this.geriatrica = geriatrica;
  }

  public GE_Locomocao getLocomocao() {
    return locomocao;
  }

  public void setLocomocao(GE_Locomocao locomocao) {
    this.locomocao = locomocao;
  }

  public GE_Exame getExame() {
    return exame;
  }

  public void setExame(GE_Exame exame) {
    this.exame = exame;
  }

  public GE_Reflexos getReflexos() {
    return reflexos;
  }

  public void setReflexos(GE_Reflexos reflexos) {
    this.reflexos = reflexos;
  }

  public List<Geriatrica> getGeriatricas() {
    return geriatricas;
  }

  public void setGeriatricas(List<Geriatrica> geriatricas) {
    this.geriatricas = geriatricas;
  }

  public List<GE_Exame> getExames() {
    return exames;
  }

  public void setExames(List<GE_Exame> exames) {
    this.exames = exames;
  }

  public List<GE_Locomocao> getLocomocaos() {
    return locomocaos;
  }

  public void setLocomocaos(List<GE_Locomocao> locomocaos) {
    this.locomocaos = locomocaos;
  }

  public List<GE_Reflexos> getGe_Reflexos() {
    return ge_Reflexos;
  }

  public void setGe_Reflexos(List<GE_Reflexos> ge_Reflexos) {
    this.ge_Reflexos = ge_Reflexos;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public void setConsultas(List<Consulta> consultas) {
    this.consultas = consultas;
  }

  public Geriatrica getRetorno() {
    return retorno;
  }

  public void setRetorno(Geriatrica retorno) {
    this.retorno = retorno;
  }

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

  public void novo() {
    try {
      geriatrica = new Geriatrica();
      exame = new GE_Exame();
      locomocao = new GE_Locomocao();
      reflexos = new GE_Reflexos();
      retorno = new Geriatrica();

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova Avaliação");
      e.printStackTrace();
    }
  }

  public void salvar() {
    try {

      GeriatricaDAO geriatricaDAO = new GeriatricaDAO();
      GE_ExameDAO exameDAO = new GE_ExameDAO();
      GE_LocomocaoDAO locomocaoDAO = new GE_LocomocaoDAO();
      GE_ReflexosDAO reflexosDAO = new GE_ReflexosDAO();
      ConsultaDAO consultaDAO = new ConsultaDAO();

      geriatrica.setConsulta(consulta);

      retorno = geriatricaDAO.merge(geriatrica);

      exame.setGeriatrica(retorno);
      locomocao.setGeriatrica(retorno);
      reflexos.setGeriatrica(retorno);

      exameDAO.merge(exame);
      locomocaoDAO.merge(locomocao);
      reflexosDAO.merge(reflexos);

      consulta.setStatus('R');
      consultaDAO.merge(consulta);
      novo();
      listaConsultas();
      Messages.addGlobalInfo("Avaliação realizada com sucesso!");

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Avaliação");
      e.printStackTrace();
    }
  }

  @PostConstruct
  public void listaConsultas() {
    Character tipo[] = { 'A' };
    Character tipos[] = { 'M', 'C', 'R' };
    Character tiposs[] = { 'G' };

    try {
      ConsultaDAO consultaDAO = new ConsultaDAO();

      consultas = consultaDAO.listarTipos3("tipo", tipo, "status", tipos, "avaliacao", tiposs);

    } catch (Exception e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar o consultas");
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

  public void excluir(ActionEvent event) {
    try {
      consulta = (Consulta) event.getComponent().getAttributes().get("consultaSelecionada");

      ConsultaDAO consultaDAO = new ConsultaDAO();
      if (consulta.getStatus().equals('M')) {
        consulta.setStatus('C');
        consultaDAO.merge(consulta);
        listaConsultas();
        Messages.addGlobalInfo("Consulta cancelada com sucesso!");

      } else {
        Messages.addGlobalWarn("Consulta não pode ser cancelada!");
      }

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado");
      e.printStackTrace();
    }
  }
  
  
  public void imprimir() {
    try {
      DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
      Map<String, Object> filtros = tabela.getFilters();

      String nomeEstado = (String) filtros.get("nome");
      String siglaEstado = (String) filtros.get("sigla");

      String caminho = Faces.getRealPath("/resources/reports/rel_Pacientes.jasper");

      Map<String, Object> parametros = new HashMap<>();

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
        System.out.println("SemPagina");
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
