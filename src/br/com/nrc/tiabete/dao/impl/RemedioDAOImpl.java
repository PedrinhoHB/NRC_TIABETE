package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.RemedioDAO;
import br.com.nrc.tiabete.entity.Remedio;

public class RemedioDAOImpl extends GenericDAOImpl<Remedio, Integer> implements RemedioDAO {

	public RemedioDAOImpl(EntityManager em) {
		super(em);
	}
}
