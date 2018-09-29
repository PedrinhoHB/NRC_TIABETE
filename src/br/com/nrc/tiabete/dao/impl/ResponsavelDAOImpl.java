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
		return em.createQuery("d.* from ResponsavelDependente rp "
				+ "join Responsavel r on rp.codigo = r.codigo "
				+ "join Dependente d on rp.codigo = d.codigo "
				+ "where r.codigo = :idResp", Dependente.class).setParameter("idResp", idResp)
				.getResultList();
	}
}
