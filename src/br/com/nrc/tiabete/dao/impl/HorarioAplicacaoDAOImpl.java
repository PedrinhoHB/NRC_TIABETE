package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.HorarioAplicacaoDAO;
import br.com.nrc.tiabete.entity.HorarioAplicacao;

public class HorarioAplicacaoDAOImpl extends GenericDAOImpl<HorarioAplicacao, Integer> implements HorarioAplicacaoDAO {

	public HorarioAplicacaoDAOImpl(EntityManager em) {
		super(em);
	}
}
