package br.com.nunes.fisioterapia.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.nunes.fisioterapia.util.HibernateUtil;

public class GenericDAO<Entidade> {
  private Class<Entidade> classe;

  @SuppressWarnings("unchecked")
  public GenericDAO() {
    this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  public void salvar(Entidade entidade) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    Transaction transacao = null;

    try {
      transacao = sessao.beginTransaction();
      sessao.save(entidade);
      transacao.commit();
    } catch (RuntimeException erro) {
      if (transacao != null) {
        transacao.rollback();
      }
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listar() {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {

      Criteria consulta = sessao.createCriteria(classe);
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listar(String campoOrdenacao) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.addOrder(Order.asc(campoOrdenacao));
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listarTipo(String campo, Character valor) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.add(Restrictions.like(campo, valor));
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listarTipoDuplo(String campo, Character valor, String campo2,
      Character valor2) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.add(Restrictions.like(campo, valor));
      consulta.add(Restrictions.like(campo2, valor2));
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listarTipos(String campo, Character[] valor) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.add(Restrictions.in(campo, valor));
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listarTiposDuplo(String campo, Character[] valor, String campo2,
      Character[] valor2) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.add(Restrictions.in(campo, valor));
      consulta.add(Restrictions.in(campo2, valor2));
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public List<Entidade> listarTipos3(String campo, Character[] valor, String campo2,
      Character[] valor2, String campo3, Character[] valor3) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.add(Restrictions.in(campo, valor));
      consulta.add(Restrictions.in(campo2, valor2));
      consulta.add(Restrictions.in(campo3, valor3));
      List<Entidade> resultado = consulta.list();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  @SuppressWarnings("unchecked")
  public Entidade buscar(Long codigo) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    try {
      Criteria consulta = sessao.createCriteria(classe);
      consulta.add(Restrictions.idEq(codigo));
      Entidade resultado = (Entidade) consulta.uniqueResult();
      return resultado;
    } catch (RuntimeException erro) {
      throw erro;
    } finally {
      sessao.close();
    }
  }

  public void excluir(Entidade entidade) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    Transaction transacao = null;

    try {
      transacao = sessao.beginTransaction();
      sessao.delete(entidade);
      transacao.commit();
    } catch (RuntimeException erro) {
      if (transacao != null) {
        transacao.rollback();
      }
      throw erro;
    } finally {
      sessao.close();
    }
  }

  public void editar(Entidade entidade) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    Transaction transacao = null;

    try {
      transacao = sessao.beginTransaction();
      sessao.update(entidade);
      transacao.commit();
    } catch (RuntimeException erro) {
      if (transacao != null) {
        transacao.rollback();
      }
      throw erro;
    } finally {
      sessao.close();
    }
  }

  public Entidade merge(Entidade entidade) {
    Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
    Transaction transacao = null;

    try {
      transacao = sessao.beginTransaction();
      @SuppressWarnings("unchecked")
      Entidade retorno = (Entidade) sessao.merge(entidade);
      transacao.commit();
      return retorno;
    } catch (RuntimeException erro) {
      if (transacao != null) {
        transacao.rollback();
      }
      throw erro;
    } finally {
      sessao.close();
    }
  }
}
