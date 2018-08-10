package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.InsulinaDependenteDAO;
import br.com.nrc.tiabete.entity.InsulinaDependente;

public class InsulinaDependenteDAOImpl extends GenericDAOImpl<InsulinaDependente, Integer>
		implements InsulinaDependenteDAO {

	public InsulinaDependenteDAOImpl(EntityManager em) {
		super(em);
	}
}
