package br.com.nunes.fisioterapia.dao;

import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.Tratamento;

public class TratamentoDAOTest {

  @Test
  public void salvar() {
    Tratamento tratamento = new Tratamento();
    Consulta consulta = new Consulta();

    TratamentoDAO tratamentoDAO = new TratamentoDAO();
    ConsultaDAO consultaDAO = new ConsultaDAO();

    consulta = consultaDAO.buscar(1L);
    
    tratamento.setConsulta(consulta);
    tratamento.setDescricao("asd");
    
    tratamentoDAO.salvar(tratamento);
    

  }

}
