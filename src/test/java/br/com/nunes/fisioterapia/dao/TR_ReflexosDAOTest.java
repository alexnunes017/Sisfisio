package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.TR_Adm;
import br.com.nunes.fisioterapia.domain.TR_Reflexos;
import br.com.nunes.fisioterapia.domain.Traumatologica;

public class TR_ReflexosDAOTest {

	TR_Reflexos modelo;
	TR_ReflexosDAO dao;
	Traumatologica modeloExterno;
	TraumatologicaDAO daoExterno;

	@Test
	public void salvar() {

		modeloExterno = new Traumatologica();
		dao = new TR_ReflexosDAO();
		daoExterno = new TraumatologicaDAO();
		modeloExterno = daoExterno.buscar(1L);
		modelo = new TR_Reflexos("reflexos", "direita", "esquerda", modeloExterno);
		dao.salvar(modelo);

	}

}
