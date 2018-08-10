package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ValorGlicemicoDAO;
import br.com.nrc.tiabete.entity.ValorGlicemico;

public class ValorGlicemicoDAOImpl extends GenericDAOImpl<ValorGlicemico, Integer> implements ValorGlicemicoDAO {

	public ValorGlicemicoDAOImpl(EntityManager em) {
		super(em);
	}
}
