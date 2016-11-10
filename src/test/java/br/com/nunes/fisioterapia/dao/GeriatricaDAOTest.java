package br.com.nunes.fisioterapia.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.Geriatrica;

public class GeriatricaDAOTest {

	Geriatrica modelo;
	Geriatrica modeloExterno;

	@Test
	public void salvar() {
		GeriatricaDAO dao = new GeriatricaDAO();
		Consulta consulta = new Consulta();
		ConsultaDAO dao2 = new ConsultaDAO();
		consulta = dao2.buscar(5L);
		modelo = new Geriatrica("qp", "hpma", "PA", 12.5, 12.5, 23.3, "insp", "retr", "leito", "dia",consulta);
		dao.merge(modelo);

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
