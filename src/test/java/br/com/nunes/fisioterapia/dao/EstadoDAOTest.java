package br.com.nunes.fisioterapia.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Estado;

public class EstadoDAOTest {

	@Test

	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
		System.err.println("Salvar");
	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 10L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());

			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);

			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total de Registros Encontrados: " + resultado.size());

		for (Estado estado : resultado) {
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Estado estado = new Estado();
		estado.setCodigo(3L);
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.excluir(estado);
		System.err.println("Excluir");
	}

	@Test
	@Ignore
	public void merge() {
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.merge(estado);
		System.err.println("Merge");
	}

	@Test
	public void buscar() {
		Long codigo = 3L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}

	@Test
	public void listarOrdenado() {
		List<Estado> list = new ArrayList<>();
		EstadoDAO estadoDAO = new EstadoDAO();
		list = estadoDAO.listar("nome");
		for (@SuppressWarnings("unused") Estado estado : list) {
			System.out.println(list.get(1));
		}
		System.err.println("ListarOrdenado");
	}

}
