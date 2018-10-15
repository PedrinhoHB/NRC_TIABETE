package br.com.nrc.tiabete.dao.impl;

import java.util.Collection;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ValorGlicemicoDAO;
import br.com.nrc.tiabete.entity.ValorGlicemico;

public class ValorGlicemicoDAOImpl extends GenericDAOImpl<ValorGlicemico, Integer> implements ValorGlicemicoDAO {

	public ValorGlicemicoDAOImpl(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Object[]> mediaGlicemicaSemanal(int codigo) {
		return em.createNativeQuery(
				"SELECT\r\n" + "TO_CHAR(VG.DS_HORA, 'Day' , 'NLS_DATE_LANGUAGE=PORTUGUESE' ) AS DIA_DA_SEMANA,\r\n"
						+ "TO_CHAR(VG.DS_HORA, 'DD/MM/YYYY') AS DATA,\r\n" + "AVG(VG.VL_MEDICAO) AS MEDIA\r\n"
						+ "FROM T_NRC_VALOR_GLICEMICO VG\r\n" + "WHERE\r\n" + "VG.CD_USUARIO = " + codigo + "\r\n"
						+ "AND TO_CHAR(VG.DS_HORA, 'dd/MM/yy') " + "IN (\r\n" + "TO_CHAR(SYSDATE, 'DD/MM/YY'),\r\n"
						+ "TO_CHAR(SYSDATE - 1, 'DD/MM/YY'),\r\n" + "TO_CHAR(SYSDATE - 2, 'DD/MM/YY'),\r\n"
						+ "TO_CHAR(SYSDATE - 3, 'DD/MM/YY'),\r\n" + "TO_CHAR(SYSDATE - 4, 'DD/MM/YY'),\r\n"
						+ "TO_CHAR(SYSDATE - 5, 'DD/MM/YY'),\r\n" + "TO_CHAR(SYSDATE - 6, 'DD/MM/YY')\r\n" + ")\r\n"
						+ "GROUP BY VG.CD_USUARIO, VG.DS_HORA\r\n" + "ORDER BY VG.DS_HORA\r\n")
				.getResultList();
	}
}
