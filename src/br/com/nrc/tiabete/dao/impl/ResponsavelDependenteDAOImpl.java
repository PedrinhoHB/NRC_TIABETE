package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDependenteDAO;
import br.com.nrc.tiabete.entity.ResponsavelDependente;

public class ResponsavelDependenteDAOImpl extends GenericDAOImpl<ResponsavelDependente, Integer>
		implements ResponsavelDependenteDAO {

	public ResponsavelDependenteDAOImpl(EntityManager em) {
		super(em);
	}
}
