package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AplicacaoDAO;
import br.com.nrc.tiabete.entity.Aplicacao;

public class AplicacaoDAOImpl extends GenericDAOImpl<Aplicacao, Integer> implements AplicacaoDAO {

	public AplicacaoDAOImpl(EntityManager em) {
		super(em);
	}
}
