package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.TR_Adm;
import br.com.nunes.fisioterapia.domain.Traumatologica;

public class TR_AdmDAOTest {

	TR_Adm modelo;
	TR_AdmDAO dao;
	Traumatologica modeloExterno;
	TraumatologicaDAO daoExterno;

	@Test
	public void salvar() {

		modeloExterno = new Traumatologica();
		dao = new TR_AdmDAO();
		daoExterno = new TraumatologicaDAO();
		modeloExterno = daoExterno.buscar(1L);
		modelo = new TR_Adm("movimento", "direita", "esquerda", modeloExterno);
		dao.salvar(modelo);

	}

}
