package br.com.nrc.tiabete.dao.impl;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.DependenteDAO;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.util.DataCalendar;

public class DependenteDAOImpl extends GenericDAOImpl<Dependente, Integer> implements DependenteDAO {

	public DependenteDAOImpl(EntityManager em) {
		super(em);
	}

	public void insereComDtCriacao(Dependente dependente) throws CommitException {
		DataCalendar dc = new DataCalendar();
		dependente.setDataCriacao(new GregorianCalendar(dc.getDataHoraAtual().get("Ano"), dc.getDataHoraAtual().get("Mes"),
				dc.getDataHoraAtual().get("Dia"), dc.getDataHoraAtual().get("Hora"), dc.getDataHoraAtual().get("Minuto"),
				dc.getDataHoraAtual().get("Segundo")));
		inserir(dependente);
		commit();
	}

	public void atualizaComDtUltAlteracao(Dependente dependente, int codigo) throws CommitException {
		DataCalendar dc = new DataCalendar();
		dependente.setDataCriacao(new GregorianCalendar(dc.getDataHoraAtual().get("Ano"), dc.getDataHoraAtual().get("Mes"),
				dc.getDataHoraAtual().get("Dia"), dc.getDataHoraAtual().get("Hora"), dc.getDataHoraAtual().get("Minuto"),
				dc.getDataHoraAtual().get("Segundo")));
		atualizar(dependente);
		commit();
	}
}
