package br.com.nrc.tiabete.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDAO;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Responsavel;

public class ResponsavelDAOImpl extends GenericDAOImpl<Responsavel, Integer> implements ResponsavelDAO {

	public ResponsavelDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public List<Dependente> dependentesPorResponsavel(int idResp) {
		return em.createQuery("select d.codigo, d.nome from ResponsavelDependente rp, Dependente d, Responsavel r "
				+ "where r.codigo = :idResp", Dependente.class).setParameter("idResp", idResp)
				.getResultList();
	}
}
