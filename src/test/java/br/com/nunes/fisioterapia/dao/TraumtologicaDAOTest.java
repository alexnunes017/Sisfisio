package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.TR_Adm;
import br.com.nunes.fisioterapia.domain.TR_ForcaMuscular;
import br.com.nunes.fisioterapia.domain.TR_Reflexos;
import br.com.nunes.fisioterapia.domain.TR_Sensibilidade;
import br.com.nunes.fisioterapia.domain.TR_TestesEspeciais;
import br.com.nunes.fisioterapia.domain.Traumatologica;

public class TraumtologicaDAOTest {

	Traumatologica modelo;
	Traumatologica retorno;

	TraumatologicaDAO dao;
	TR_AdmDAO dao2;
	TR_Adm adm;
	TR_ForcaMuscular muscular;
	TR_ForcaMuscularDAO dao3;
	TR_ReflexosDAO dao4;
	TR_Reflexos reflexos;
	TR_SensibilidadeDAO dao5;
	TR_Sensibilidade sensibilidade;
	TR_TestesEspeciaisDAO dao6;
	TR_TestesEspeciais especiais;

	@Test
	public void salvar() {
		Consulta consulta = new Consulta();
		ConsultaDAO daoC = new ConsultaDAO();
		consulta = daoC.buscar(5L);

		modelo = new Traumatologica("qp", "hpma", "exame", true, true, true, "eva", "patalogias", "exame", "12/08",
				"18bpm", "inspecao", "palpcao", "discrepancia", "diagnostico", consulta);
		dao = new TraumatologicaDAO();
		dao2 = new TR_AdmDAO();
		dao3 = new TR_ForcaMuscularDAO();
		dao4 = new TR_ReflexosDAO();
		dao5 = new TR_SensibilidadeDAO();
		dao6 = new TR_TestesEspeciaisDAO();

		retorno = dao.merge(modelo);

		adm = new TR_Adm("movimento", "direita", "esquerda", retorno);
		muscular = new TR_ForcaMuscular("musculos", "direita", "esquerda", retorno);
		reflexos = new TR_Reflexos("movimento", "direita", "esquerda", retorno);
		sensibilidade = new TR_Sensibilidade("movimento", "direita", "esquerda", retorno);
		especiais = new TR_TestesEspeciais("movimento", "direita", "esquerda", retorno);

		dao2.merge(adm);
		dao3.merge(muscular);
		dao4.merge(reflexos);
		dao5.merge(sensibilidade);
		dao6.merge(especiais);

	}

}
