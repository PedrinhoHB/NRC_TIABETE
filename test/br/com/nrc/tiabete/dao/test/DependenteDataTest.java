package br.com.nrc.tiabete.dao.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.DependenteDAO;
import br.com.nrc.tiabete.dao.impl.DependenteDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Genero;
import br.com.nrc.tiabete.entity.TipoDiabete;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;

public class DependenteDataTest {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		DependenteDAO dao = new DependenteDAOImpl(em);

		Dependente dependente = new Dependente();

		TipoDiabete tipoDiabete = new TipoDiabete();

		dependente.setAltura(1.75);
		dependente.setEmail("pedrobizzarri@gmail.com");
		dependente.setFoto(null);
		dependente.setNome("Pedro");
		dependente.setPeso(75);
		dependente.setSenha("Abacate123");
		dependente.setGenero(Genero.MASCULINO);
		dependente.setMedidor("Accu-Chek");
		dependente.setModeloMedidor("1455");
		dependente.setTipoDiabete(tipoDiabete);
		dependente.setDataNascimento(new GregorianCalendar(1998, Calendar.APRIL, 27));

		dao.insereComDtCriacao(dependente);

		em.close();
	}
}
