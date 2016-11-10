package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.nunes.fisioterapia.dao.ConsultaDAO;
import br.com.nunes.fisioterapia.dao.NE_IndiceDAO;
import br.com.nunes.fisioterapia.dao.NE_SensibilidadeProfundaDAO;
import br.com.nunes.fisioterapia.dao.NE_TonusDAO;
import br.com.nunes.fisioterapia.dao.NeurologicaDAO;
import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.NE_Indice;
import br.com.nunes.fisioterapia.domain.NE_SensibilidadeProfunda;
import br.com.nunes.fisioterapia.domain.NE_Tonus;
import br.com.nunes.fisioterapia.domain.Neurologica;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class NeurologicaBean implements Serializable {

  private Neurologica neurologica;
  private Neurologica retorno;
  private List<Neurologica> neurologicas;
  private NE_Indice indice;
  private NE_Tonus tonus;
  private NE_SensibilidadeProfunda profunda;
  private List<NE_Indice> ne_Indices;
  private List<NE_Tonus> ne_Tonus;
  private List<Consulta> consultas;
  private Consulta consulta;

  public Neurologica getNeurologica() {
    return neurologica;
  }

  public void setNeurologica(Neurologica neurologica) {
    this.neurologica = neurologica;
  }

  public Neurologica getRetorno() {
    return retorno;
  }

  public void setRetorno(Neurologica retorno) {
    this.retorno = retorno;
  }

  public List<Neurologica> getNeurologicas() {
    return neurologicas;
  }

  public void setNeurologicas(List<Neurologica> neurologicas) {
    this.neurologicas = neurologicas;
  }

  public NE_Indice getIndice() {
    return indice;
  }

  public void setIndice(NE_Indice indice) {
    this.indice = indice;
  }

  public NE_Tonus getTonus() {
    return tonus;
  }

  public void setTonus(NE_Tonus tonus) {
    this.tonus = tonus;
  }

  public NE_SensibilidadeProfunda getProfunda() {
    return profunda;
  }

  public void setProfunda(NE_SensibilidadeProfunda profunda) {
    this.profunda = profunda;
  }

  public List<NE_Indice> getNe_Indices() {
    return ne_Indices;
  }

  public void setNe_Indices(List<NE_Indice> ne_Indices) {
    this.ne_Indices = ne_Indices;
  }

  public List<NE_Tonus> getNe_Tonus() {
    return ne_Tonus;
  }

  public void setNe_Tonus(List<NE_Tonus> ne_Tonus) {
    this.ne_Tonus = ne_Tonus;
  }

  public List<Consulta> getConsultas() {
    return consultas;
  }

  public void setConsultas(List<Consulta> consultas) {
    this.consultas = consultas;
  }

  public Consulta getConsulta() {
    return consulta;
  }

  public void setConsulta(Consulta consulta) {
    this.consulta = consulta;
  }

  public void novo() {
    try {
      neurologica = new Neurologica();
      retorno = new Neurologica();
      indice = new NE_Indice();
      tonus = new NE_Tonus();
      profunda = new NE_SensibilidadeProfunda();

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova Avaliação");
      e.printStackTrace();
    }
  }

  public void salvar() {
    try {

      NeurologicaDAO neurologicaDAO = new NeurologicaDAO();
      NE_IndiceDAO indiceDAO = new NE_IndiceDAO();
      NE_TonusDAO tonusDAO = new NE_TonusDAO();
      NE_SensibilidadeProfundaDAO profundaDAO = new NE_SensibilidadeProfundaDAO();
      ConsultaDAO consultaDAO = new ConsultaDAO();

      neurologica.setConsulta(consulta);

      retorno = neurologicaDAO.merge(neurologica);

      indice.setNeurologica(retorno);
      tonus.setNeurologica(retorno);
      profunda.setNeurologica(retorno);

      int soma = indice.getAlimentacao() + indice.getAsseio() + indice.getEvacuacao()
          + indice.getMiccao() + indice.getVestir() + indice.getTranferencia() + indice.getToalet()
          + indice.getMobilidade() + indice.getEscadas() + indice.getBanho();

      indice.setTotal(soma);
      indiceDAO.merge(indice);
      tonusDAO.merge(tonus);
      profundaDAO.merge(profunda);

      consulta.setStatus('R');
      consultaDAO.merge(consulta);
      novo();
      listaConsultas();
      Messages.addGlobalInfo("Avaliação realizada com sucesso!");

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Avaliação");
      e.printStackTrace();
    }
  }

  @PostConstruct
  public void listaConsultas() {
    Character tipo[] = { 'A' };
    Character tipos[] = { 'M', 'C', 'R' };
    Character tiposs[] = { 'N' };

    try {
      ConsultaDAO consultaDAO = new ConsultaDAO();

      consultas = consultaDAO.listarTipos3("tipo", tipo, "status", tipos, "avaliacao", tiposs);

    } catch (Exception e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar listar o consultas");
      e.printStackTrace();
    }
  }

  public void editar(ActionEvent event) {
    consulta = (Consulta) event.getComponent().getAttributes().get("consultaSelecionada");
    consulta.getFisioterapeuta().getPessoa();
    consulta.getPessoa();
    consulta.getMedico();
    novo();
  }

  public void excluir(ActionEvent event) {
    try {
      consulta = (Consulta) event.getComponent().getAttributes().get("consultaSelecionada");

      ConsultaDAO consultaDAO = new ConsultaDAO();
      if (consulta.getStatus().equals('M')) {
        consulta.setStatus('C');
        consultaDAO.merge(consulta);
        listaConsultas();
        Messages.addGlobalInfo("Consulta cancelada com sucesso!");

      } else {
        Messages.addGlobalWarn("Consulta não pode ser cancelada!");
      }

    } catch (RuntimeException e) {
      Messages.addGlobalError("Ocorreu um erro ao tentar excluir o estado");
      e.printStackTrace();
    }
  }
}
