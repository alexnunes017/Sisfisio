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

import br.com.nunes.fisioterapia.dao.CidadeDAO;
import br.com.nunes.fisioterapia.dao.EstadoDAO;
import br.com.nunes.fisioterapia.domain.Cidade;
import br.com.nunes.fisioterapia.domain.Estado;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
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
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar o cidades");
			e.printStackTrace();
		}
	}

	public void novo() {
		try {
			cidade = new Cidade();
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova cidade");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.merge(cidade);
			novo();
			listar();
			Messages.addGlobalInfo("Cidade salva com sucesso!");

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o cidade");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			cidade = (Cidade) event.getComponent().getAttributes().get("cidadeSelecionada");
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.excluir(cidade);
			listar();
			Messages.addGlobalInfo("Cidade excluida com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o cidade");
			e.printStackTrace();
		}
	}

	public void editar(ActionEvent event) {
		cidade = (Cidade) event.getComponent().getAttributes().get("cidadeSelecionada");

	}

	public void imprimir() {
		try {
			DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
			Map<String, Object> filtros = tabela.getFilters();

			String nomeCidade = (String) filtros.get("nome");
			String nomeEstado = (String) filtros.get("estado.nome");

			String caminho = Faces.getRealPath("/resources/reports/rel_Cidades.jasper");

			// String caminhoBanner =
			// Faces.getRealPath("/resources/images/banner2.jpg");

			Map<String, Object> parametros = new HashMap<>();

			if (nomeCidade == null) {
				parametros.put("nomeCidade", "%%");
			} else {
				parametros.put("nomeCidade", "%" + nomeCidade + "%");
			}
			if (nomeEstado == null) {
				parametros.put("nomeEstado", "%%");
			} else {
				parametros.put("nomeEstado", "%" + nomeEstado + "%");
			}

			// parametros.put("CAMINHO_BANNER", caminhoBanner);

			Connection conexao = HibernateUtil.getConexao();

			JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
			JasperViewer viewer = new JasperViewer(relatorio, false);

			if (relatorio.getAnchorIndexes().isEmpty()) {
				System.out.println("SemPagina");
			} else {
				viewer.setTitle("Relátorio de Cidade(s)");
				viewer.setVisible(true);
				viewer.toFront();
			} // JasperPrintManager.printReport(relatorio, true);

		} catch (JRException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
			erro.printStackTrace();
		}
	}
}
