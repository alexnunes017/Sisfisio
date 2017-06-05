package br.com.nunes.fisioterapia.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Cidade;
import br.com.nunes.fisioterapia.domain.Pessoa;

public class PessoaDAOTest {
	
	@Test
	public void salvar() {

		Cidade cidade = new Cidade();
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidade = cidadeDAO.buscar(1L);
		Pessoa pessoa = new Pessoa("Alex","000.000.000-00","555","rua",1,"asd","asd","asd","asd","asd","asd",'M',cidade);
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.merge(pessoa);
		
	}

	@Test
	public void editar() {
		;
	}

	@Test
	public void listar() {

	}

	@Test
	@Ignore
	public void excluir() {

	}

	@Test
	public void merge() {

	}

	@Test
	public void buscar() {

	}

	@Test
	public void listarOrdenado() {

	}
}
