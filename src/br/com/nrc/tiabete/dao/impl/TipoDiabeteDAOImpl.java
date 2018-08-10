package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.TipoDiabeteDAO;
import br.com.nrc.tiabete.entity.TipoDiabete;

public class TipoDiabeteDAOImpl extends GenericDAOImpl<TipoDiabete, Integer> implements TipoDiabeteDAO {

	public TipoDiabeteDAOImpl(EntityManager em) {
		super(em);
	}
}
