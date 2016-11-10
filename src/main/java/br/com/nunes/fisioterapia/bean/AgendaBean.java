package br.com.nunes.fisioterapia.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.component.schedule.Schedule;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import com.mysql.fabric.xmlrpc.base.Data;

import br.com.nunes.fisioterapia.dao.ConsultaDAO;
import br.com.nunes.fisioterapia.domain.Consulta;
import br.com.nunes.fisioterapia.domain.Usuario;



@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class AgendaBean implements Serializable {

	private ScheduleEvent scheduleEvent;
	private ScheduleModel scheduleModel;
	private List<Consulta> consultas;
	private Consulta consulta;
	private Usuario usuario;

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ScheduleModel getScheduleModel() {
		return scheduleModel;
	}

	public void setScheduleModel(ScheduleModel scheduleModel) {
		this.scheduleModel = scheduleModel;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	@PostConstruct
	public void listar() {
		try {

			ConsultaDAO consultaDAO = new ConsultaDAO();
			consultas = consultaDAO.listar();

			//evento = new DefaultScheduleEvent(consultas, new Date(), new Date());
			//evento.addEvent(new DefaultScheduleEvent());

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar os agendamentos");
			e.printStackTrace();
		}
	}

}
