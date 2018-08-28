package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.EnclosureDAO;
import br.com.nrc.tiabete.entity.news.Enclosure;

public class EnclosureDAOImpl extends GenericDAOImpl<Enclosure, Integer> implements EnclosureDAO {

	public EnclosureDAOImpl(EntityManager em) {
		super(em);
	}
}
