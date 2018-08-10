package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.RefeicaoDAO;
import br.com.nrc.tiabete.entity.Refeicao;

public class RefeicaoDAOImpl extends GenericDAOImpl<Refeicao, Integer> implements RefeicaoDAO {

	public RefeicaoDAOImpl(EntityManager em) {
		super(em);
	}
}
