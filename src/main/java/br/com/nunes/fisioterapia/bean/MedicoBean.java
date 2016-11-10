package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.nunes.fisioterapia.dao.MedicoDAO;
import br.com.nunes.fisioterapia.domain.Medico;

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
}
