package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;
import org.primefaces.component.datatable.DataTable;

import br.com.nunes.fisioterapia.dao.CidadeDAO;
import br.com.nunes.fisioterapia.dao.EstadoDAO;
import br.com.nunes.fisioterapia.dao.PessoaDAO;
import br.com.nunes.fisioterapia.dao.UsuarioDAO;
import br.com.nunes.fisioterapia.domain.Cidade;
import br.com.nunes.fisioterapia.domain.Estado;
import br.com.nunes.fisioterapia.domain.Pessoa;
import br.com.nunes.fisioterapia.domain.Usuario;
import br.com.nunes.fisioterapia.util.HibernateUtil;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
  private Usuario usuario;

  private List<Pessoa> pessoas;
  private List<Usuario> usuarios;

  private Estado estado;
  private List<Estado> estados;

  private List<Cidade> cidades;

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }

  public List<Pessoa> getPessoas() {
    return pessoas;
  }

  public void setPessoas(List<Pessoa> pessoas) {
    this.pessoas = pessoas;
  }

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void setUsuarios(List<Usuario> usuarios) {
    this.usuarios = usuarios;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
  }

  public List<Estado> getEstados() {
    return estados;
  }

  public void setEstados(List<Estado> estados) {
    this.estados = estados;
  }

  public List<Cidade> getCidades() {
    return cidades;
  }

  public void setCidades(List<Cidade> cidades) {
    this.cidades = cidades;
  }

  @PostConstruct
  public void listar() {
    try {
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      usuarios = usuarioDAO.listar("tipo");
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar os usuários");
      erro.printStackTrace();
    }
  }

  public void novo() {
    try {
      usuario = new Usuario();
      Character tipos[] = { 'F', 'U' };
      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoas = pessoaDAO.listarTipos("tipo", tipos);
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo usuário");
      erro.printStackTrace();
    }
  }

  public void salvar() {
    try {
      UsuarioDAO usuarioDAO = new UsuarioDAO();
      SimpleHash hash = new SimpleHash("md5", usuario.getSenha());

      usuario.setSenha(hash.toHex());

      usuarioDAO.merge(usuario);

      usuario = new Usuario();
      usuarios = usuarioDAO.listar("tipo");

      PessoaDAO pessoaDAO = new PessoaDAO();
      pessoas = pessoaDAO.listar("nome");

      Messages.addGlobalInfo("Usuário salvo com sucesso");
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o usuário");
      erro.printStackTrace();
    }
  }

  public void editar(ActionEvent evento) {
    try {
      novo();
      usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

      estado = usuario.getPessoa().getCidade().getEstado();

      EstadoDAO estadoDAO = new EstadoDAO();
      estados = estadoDAO.listar("nome");

      CidadeDAO cidadeDAO = new CidadeDAO();
      cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
    } catch (RuntimeException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar selecionar o usuario");
    }
  }

  public void excluir(ActionEvent evento) {
    try {
      usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionado");

      usuario.setAtivo(false);

      UsuarioDAO usuarioDAO = new UsuarioDAO();
      usuarioDAO.merge(usuario);
      listar();
      Messages.addGlobalInfo("Usuario inativado com sucesso!");
    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir a pessoa");
      e.printStackTrace();
    }
  }

  public void imprimir() {
    try {
      DataTable tabela = (DataTable) Faces.getViewRoot().findComponent("formListagem:tabela");
      Map<String, Object> filtros = tabela.getFilters();

      String nomeEstado = (String) filtros.get("nome");
      String siglaEstado = (String) filtros.get("sigla");

      String caminho = Faces.getRealPath("/resources/reports/rel_Estados.jasper");

      // String caminhoBanner =
      // Faces.getRealPath("/resources/images/banner2.jpg");

      Map<String, Object> parametros = new HashMap<>();

      if (nomeEstado == null) {
        parametros.put("nomeEstado", "%%");
      } else {
        parametros.put("nomeEstado", "%" + nomeEstado + "%");
      }
      if (siglaEstado == null) {
        parametros.put("siglaEstado", "%%");
      } else {
        parametros.put("siglaEstado", "%" + siglaEstado + "%");
      }

      // parametros.put("CAMINHO_BANNER", caminhoBanner);

      Connection conexao = HibernateUtil.getConexao();

      JasperPrint relatorio = JasperFillManager.fillReport(caminho, parametros, conexao);
      JasperViewer viewer = new JasperViewer(relatorio, false);
      if (relatorio.getAnchorIndexes().isEmpty()) {
        System.out.println("SemPagina");
      } else {

        viewer.setTitle("Relátorio de Estado(s)");
        viewer.setVisible(true);
        viewer.toFront();
      }
      ;
      // JasperPrintManager.printReport(relatorio, true);

    } catch (JRException erro) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar o relatório");
      erro.printStackTrace();
    }
  }

}
