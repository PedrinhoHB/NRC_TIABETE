package br.com.nrc.tiabete.dao.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ResponsavelDAO;
import br.com.nrc.tiabete.dao.ResponsavelDependenteDAO;
import br.com.nrc.tiabete.dao.impl.ResponsavelDAOImpl;
import br.com.nrc.tiabete.dao.impl.ResponsavelDependenteDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Genero;
import br.com.nrc.tiabete.entity.Responsavel;
import br.com.nrc.tiabete.entity.ResponsavelDependente;
import br.com.nrc.tiabete.entity.TipoDiabete;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class ResponsavelDependenteTest {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();

		ResponsavelDependenteDAO dao = new ResponsavelDependenteDAOImpl(em);

		Responsavel responsavel = new Responsavel();
		ResponsavelDependente respDep = new ResponsavelDependente();

		responsavel.setDataCriacao(Calendar.getInstance());
		responsavel.setDataUltimaAlteracao(Calendar.getInstance());
		responsavel.setEmail("emailteste@gmail.com");
		responsavel.setFoto(null);
		responsavel.setNome("Fernando");
		responsavel.setSenha("abacaxi123");
		responsavel.setTelefone("987458875");

		Dependente dependente = new Dependente();

		TipoDiabete tipoDiabete = new TipoDiabete();

		dependente.setAltura(1.75);
		dependente.setEmail("matheusbbenatti@gmail.com");
		dependente.setFoto(null);
		dependente.setNome("Matheus Benatti");
		dependente.setPeso(75);
		dependente.setSenha("abacaxi123");
		dependente.setDataCriacao(Calendar.getInstance());
		dependente.setDataUltimaAlteracao(Calendar.getInstance()); // colocar no DAO
		dependente.setGenero(Genero.MASCULINO);
		dependente.setMedidor("Accu-Chek");
		dependente.setModeloMedidor("15198");
		dependente.setTipoDiabete(tipoDiabete);
		dependente.setDataNascimento(new GregorianCalendar(1998, Calendar.APRIL, 27));

		respDep.setResponsavel(responsavel);
		respDep.setDependente(dependente);

		dao.inserir(respDep);
		dao.commit();

		em.close();
	}
}
