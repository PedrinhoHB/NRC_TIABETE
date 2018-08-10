package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.InsulinaDAO;
import br.com.nrc.tiabete.entity.Insulina;

public class InsulinaDAOImpl extends GenericDAOImpl<Insulina, Integer> implements InsulinaDAO {

	public InsulinaDAOImpl(EntityManager em) {
		super(em);
	}
}
