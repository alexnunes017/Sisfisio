package br.com.nunes.fisioterapia.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Cidade;
import br.com.nunes.fisioterapia.domain.Estado;

public class CidadeDAOTest {
  @Test
  public void salvar() {
    Cidade cidade = new Cidade();
    CidadeDAO cidadeDAO = new CidadeDAO();
    Estado estado = new Estado();
    EstadoDAO estadoDAO = new EstadoDAO();
    estado = estadoDAO.buscar(1L);

    cidade.setNome("Rio de Janeiro");
    cidade.setEstado(estado);
    cidadeDAO.salvar(cidade);
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
