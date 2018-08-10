package br.com.nrc.tiabete.dao.impl;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ValorGlicemidoDAO;
import br.com.nrc.tiabete.entity.ValorGlicemico;

public class ValorGlicemicoDAOImpl extends GenericDAOImpl<ValorGlicemico, Integer> implements ValorGlicemidoDAO {

	public ValorGlicemicoDAOImpl(EntityManager em) {
		super(em);
	}
}
