package br.com.nrc.tiabete.dao.test;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDAO;
import br.com.nrc.tiabete.dao.impl.ResponsavelDAOImpl;
import br.com.nrc.tiabete.entity.Responsavel;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class ResponsavelTeste {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		ResponsavelDAO dao = new ResponsavelDAOImpl(em);
		Responsavel responsavel = new Responsavel();
		
		
		responsavel.setDataCriacao(Calendar.getInstance());
		responsavel.setDataUltimaAlteracao(Calendar.getInstance());
		responsavel.setEmail("emailteste@gmail.com");
		responsavel.setFoto(null);
		responsavel.setNome("Fernando");
		responsavel.setSenha("abacaxi123");
		responsavel.setTelefone("987458875");
		
		dao.inserir(responsavel);
		dao.commit();
		em.close();
		
	}
}
