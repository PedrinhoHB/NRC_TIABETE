package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDAO;
import br.com.nrc.tiabete.entity.Responsavel;

public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Integer> implements ResponsavelDAO {

	public ResponsavelDAOImpl(EntityManager em) {
		super(em);
	}
}
