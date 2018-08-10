package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoRefeicaoDAO;
import br.com.nrc.tiabete.entity.TipoRefeicao;

public class TipoRefeicaoDAOImpl extends GenericDAOImpl<TipoRefeicao, Integer> implements TipoRefeicaoDAO {

	public TipoRefeicaoDAOImpl(EntityManager em) {
		super(em);
	}
}
