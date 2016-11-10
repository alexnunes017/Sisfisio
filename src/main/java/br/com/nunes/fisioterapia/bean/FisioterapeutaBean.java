package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.nunes.fisioterapia.dao.FisioterapeutaDAO;
import br.com.nunes.fisioterapia.dao.PessoaDAO;
import br.com.nunes.fisioterapia.domain.Fisioterapeuta;
import br.com.nunes.fisioterapia.domain.Pessoa;

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

			fisioterapeuta = (Fisioterapeuta) event.getComponent().getAttributes().get("fisioterapeutaSelecionado");
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
		fisioterapeuta = (Fisioterapeuta) event.getComponent().getAttributes().get("fisioterapeutaSelecionado");

	}
}
