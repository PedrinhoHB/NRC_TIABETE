package br.com.nrc.tiabete.dao.test;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.AlimentoDAO;
import br.com.nrc.tiabete.dao.impl.AlimentoDAOImpl;
import br.com.nrc.tiabete.entity.Alimento;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class AliementoTest {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		AlimentoDAO dao = new AlimentoDAOImpl(em);
		Alimento ali = new Alimento();

		ali.setNome("Pera");
		ali.setCarbohidrato(12);
		ali.setCargaGlicemica(6);
		ali.setUnidadeMedida("Teste");

		dao.inserir(ali);
		dao.commit();

		em.close();
	}
}
