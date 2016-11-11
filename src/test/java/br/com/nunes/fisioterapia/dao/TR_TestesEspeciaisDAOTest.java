package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.TR_TestesEspeciais;
import br.com.nunes.fisioterapia.domain.Traumatologica;

public class TR_TestesEspeciaisDAOTest {

	TR_TestesEspeciais modelo;
	TR_TestesEspeciaisDAO dao;
	Traumatologica modeloExterno;
	TraumatologicaDAO daoExterno;

	@Test
	public void salvar() {

		modeloExterno = new Traumatologica();
		dao = new TR_TestesEspeciaisDAO();
		daoExterno = new TraumatologicaDAO();
		modeloExterno = daoExterno.buscar(1L);
		modelo = new TR_TestesEspeciais("testesespeciais", "direita", "esquerda", modeloExterno);
		dao.salvar(modelo);

	}

}
