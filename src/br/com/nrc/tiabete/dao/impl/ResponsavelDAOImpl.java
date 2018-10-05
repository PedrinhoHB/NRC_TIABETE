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

	@SuppressWarnings("unchecked")
	@Override
	public List<Dependente> dependentesPorResponsavel(int idResp) {
		return em.createNativeQuery("SELECT D.*, U.*\r\n" + 
									"FROM T_NRC_RESPONSAVEL_DEPENDETNE RD\r\n" + 
									"JOIN T_NRC_DEP D\r\n" + 
									"JOIN T_NRC_USUARIO U\r\n" + 
									"ON U.CD_USUARIO = D.CD_USUARIO\r\n" + 
									"ON D.CD_USUARIO = RD.CD_DEPENDENTE\r\n" + 
									"WHERE CD_RESPONSAVEL LIKE '%" + idResp + "%'", Dependente.class)
									.getResultList();
	}
}
