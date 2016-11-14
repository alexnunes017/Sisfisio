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

import br.com.nunes.fisioterapia.dao.MedicoDAO;
import br.com.nunes.fisioterapia.domain.Medico;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class MedicoBean implements Serializable {

	private Medico medico;
	private List<Medico> medicos;

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	@PostConstruct
	public void listar() {
		try {
			MedicoDAO medicoDAO = new MedicoDAO();
			medicos = medicoDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar o medicos");
			e.printStackTrace();
		}
	}

	public void novo() {
		medico = new Medico();
	}

	public void salvar() {
		try {
			MedicoDAO medicoDAO = new MedicoDAO();
			medicoDAO.merge(medico);
			novo();
			listar();
			Messages.addGlobalInfo("Medico salvo com sucesso!");

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o medico");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			medico = (Medico) event.getComponent().getAttributes().get("medicoSelecionado");
			MedicoDAO medicoDAO = new MedicoDAO();
			medicoDAO.excluir(medico);
			listar();
			Messages.addGlobalInfo("Estado excluido com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o medico");
			e.printStackTrace();
		}
	}

	public void editar(ActionEvent event) {
		medico = (Medico) event.getComponent().getAttributes().get("medicoSelecionado");

	}
	
	public void imprimir() {
    try {
      DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
      Map<String, Object> filtros = tabela.getFilters();

      String nomeMedico = (String) filtros.get("nomeMedico");
      String crmMedico = (String) filtros.get("crmMedico");

      String caminho = Faces.getRealPath("/resources/reports/rel_Medicos.jasper");

      Map<String, Object> parametros = new HashMap<>();

      if (nomeMedico == null) {
        parametros.put("nomeMedico", "%%");
      } else {
        parametros.put("nomeMedico", "%" + nomeMedico + "%");
      }
      if (crmMedico == null) {
        parametros.put("crmMedico", "%%");
      } else {
        parametros.put("crmMedico", "%" + crmMedico + "%");
      }

      Connection conexao = HibernateUtil.getConexao();

      JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
      JasperViewer viewer = new JasperViewer(relatorio, false);
      if (relatorio.getAnchorIndexes().isEmpty()) {
        System.out.println("Não a Dados");
      } else {

        viewer.setTitle("Relátorio de Médico(s)");
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
