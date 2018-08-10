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
		dependente.setDataCriacao(new GregorianCalendar(dc.getDataAtual().get("Ano"), dc.getDataAtual().get("Mes"),
				dc.getDataAtual().get("Dia"), dc.getDataAtual().get("Hora"), dc.getDataAtual().get("Minuto"),
				dc.getDataAtual().get("Segundo")));
		inserir(dependente);
		commit();
	}

	public void atualizaComDtUltAlteracao(Dependente dependente, int codigo) throws CommitException {
		DataCalendar dc = new DataCalendar();
		dependente.setDataCriacao(new GregorianCalendar(dc.getDataAtual().get("Ano"), dc.getDataAtual().get("Mes"),
				dc.getDataAtual().get("Dia"), dc.getDataAtual().get("Hora"), dc.getDataAtual().get("Minuto"),
				dc.getDataAtual().get("Segundo")));
		atualizar(dependente);
		commit();
	}
}
