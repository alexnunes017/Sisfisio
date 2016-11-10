package br.com.nunes.fisioterapia.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.nunes.fisioterapia.domain.Pessoa;
import br.com.nunes.fisioterapia.domain.Usuario;

public class UsuarioDAOTest {
	@SuppressWarnings("unused")
  @Test
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Pessoa Encontrada");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenhaSemCriptografia("123456");
		
		SimpleHash hash = new SimpleHash("md5", usuario.getSenhaSemCriptografia());
		usuario.setSenha(hash.toHex());
		hash.toHex();	
		System.out.println(hash.toHex());
		String senha =  hash.toHex();
		
		
		
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso.");
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
