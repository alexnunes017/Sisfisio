package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.TR_Adm;
import br.com.nunes.fisioterapia.domain.TR_Sensibilidade;
import br.com.nunes.fisioterapia.domain.Traumatologica;

public class TR_SensibilidadeDAOTest {

	TR_Sensibilidade modelo;
	TR_SensibilidadeDAO dao;
	Traumatologica modeloExterno;
	TraumatologicaDAO daoExterno;

	@Test
	public void salvar() {

		modeloExterno = new Traumatologica();
		dao = new TR_SensibilidadeDAO();
		daoExterno = new TraumatologicaDAO();
		modeloExterno = daoExterno.buscar(1L);
		modelo = new TR_Sensibilidade("sensibilidade", "direita", "esquerda", modeloExterno);
		dao.salvar(modelo);

	}

}
