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
import br.com.nunes.fisioterapia.dao.TR_AdmDAO;
import br.com.nunes.fisioterapia.dao.TR_ForcaMuscularDAO;
import br.com.nunes.fisioterapia.dao.TR_ReflexosDAO;
import br.com.nunes.fisioterapia.dao.TR_SensibilidadeDAO;
import br.com.nunes.fisioterapia.dao.TR_TestesEspeciaisDAO;
import br.com.nunes.fisioterapia.dao.TraumatologicaDAO;
import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.TR_Adm;
import br.com.nunes.fisioterapia.domain.TR_ForcaMuscular;
import br.com.nunes.fisioterapia.domain.TR_Reflexos;
import br.com.nunes.fisioterapia.domain.TR_Sensibilidade;
import br.com.nunes.fisioterapia.domain.TR_TestesEspeciais;
import br.com.nunes.fisioterapia.domain.Traumatologica;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class TraumatologicaBean implements Serializable {

  private Traumatologica traumatologica;
  private Traumatologica retorno;
  private TR_Adm adm;
  private TR_ForcaMuscular muscular;
  private TR_Reflexos reflexos;
  private TR_Sensibilidade sensibilidade;
  private TR_TestesEspeciais especiais;
  private List<Traumatologica> traumatologicas;
  private List<Consulta> consultas;
  private Consulta consulta;

  public Traumatologica getTraumatologica() {
    return traumatologica;
  }

  public void setTraumatologica(Traumatologica traumatologica) {
    this.traumatologica = traumatologica;
  }

  public List<Traumatologica> getTraumatologicas() {
    return traumatologicas;
  }

  public void setTraumatologicas(List<Traumatologica> traumatologicas) {
    this.traumatologicas = traumatologicas;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public void setConsultas(List<Consulta> consultas) {
    this.consultas = consultas;
  }

  public Traumatologica getRetorno() {
    return retorno;
  }

  public void setRetorno(Traumatologica retorno) {
    this.retorno = retorno;
  }

  public TR_Adm getAdm() {
    return adm;
  }

  public void setAdm(TR_Adm adm) {
    this.adm = adm;
  }

  public TR_ForcaMuscular getMuscular() {
    return muscular;
  }

  public void setMuscular(TR_ForcaMuscular muscular) {
    this.muscular = muscular;
  }

  public TR_Reflexos getReflexos() {
    return reflexos;
  }

  public void setReflexos(TR_Reflexos reflexos) {
    this.reflexos = reflexos;
  }

  public TR_Sensibilidade getSensibilidade() {
    return sensibilidade;
  }

  public void setSensibilidade(TR_Sensibilidade sensibilidade) {
    this.sensibilidade = sensibilidade;
  }

  public TR_TestesEspeciais getEspeciais() {
    return especiais;
  }

  public void setEspeciais(TR_TestesEspeciais especiais) {
    this.especiais = especiais;
  }

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

  public void novo() {
    try {
      traumatologica = new Traumatologica();
      retorno = new Traumatologica();
      adm = new TR_Adm();
      muscular = new TR_ForcaMuscular();
      reflexos = new TR_Reflexos();
      sensibilidade = new TR_Sensibilidade();
      especiais = new TR_TestesEspeciais();

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova Avaliação");
      e.printStackTrace();
    }
  }

  public void salvar() {
    try {

      TraumatologicaDAO traumatologicaDAO = new TraumatologicaDAO();
      TR_AdmDAO admDAO = new TR_AdmDAO();
      TR_ForcaMuscularDAO muscularDAO = new TR_ForcaMuscularDAO();
      TR_ReflexosDAO reflexosDAO = new TR_ReflexosDAO();
      TR_SensibilidadeDAO sensibilidadeDAO = new TR_SensibilidadeDAO();
      TR_TestesEspeciaisDAO especiaisDAO = new TR_TestesEspeciaisDAO();
      ConsultaDAO consultaDAO = new ConsultaDAO();

      traumatologica.setConsulta(consulta);

      retorno = traumatologicaDAO.merge(traumatologica);

      adm.setTraumatologica(retorno);
      muscular.setTraumatologica(retorno);
      reflexos.setTraumatologica(retorno);
      sensibilidade.setTraumatologica(retorno);
      especiais.setTraumatologica(retorno);

      admDAO.merge(adm);
      muscularDAO.merge(muscular);
      reflexosDAO.merge(reflexos);
      sensibilidadeDAO.merge(sensibilidade);
      especiaisDAO.merge(especiais);

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
    Character tiposs[] = { 'T' };

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
