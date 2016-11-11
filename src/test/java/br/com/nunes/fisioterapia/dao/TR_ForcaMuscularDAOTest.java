package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.TR_ForcaMuscular;
import br.com.nunes.fisioterapia.domain.Traumatologica;

public class TR_ForcaMuscularDAOTest {

	TR_ForcaMuscular modelo;
	TR_ForcaMuscularDAO dao;
	Traumatologica modeloExterno;
	TraumatologicaDAO daoExterno;

	@Test
	public void salvar() {

		modeloExterno = new Traumatologica();
		dao = new TR_ForcaMuscularDAO();
		daoExterno = new TraumatologicaDAO();
		modeloExterno = daoExterno.buscar(1L);
		modelo = new TR_ForcaMuscular("musculos", "direita", "esquerda", modeloExterno);
		dao.salvar(modelo);

	}

}
