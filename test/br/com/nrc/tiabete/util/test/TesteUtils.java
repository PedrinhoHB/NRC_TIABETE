package br.com.nrc.tiabete.util.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.DependenteDAO;
import br.com.nrc.tiabete.dao.impl.DependenteDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;
import br.com.nrc.tiabete.util.DataCalendar;

public class TesteUtils {
	public static void main(String[] args) {

		DataCalendar f = new DataCalendar();

		System.out.println(f.getDataHoraAtual().get("Dia") + "/" + f.getDataHoraAtual().get("Mes") + "/"
				+ f.getDataHoraAtual().get("Ano"));

		System.out.println(f.getDataHoraAtual().get("Hora") + ":" + f.getDataHoraAtual().get("Minuto") + ":"
				+ f.getDataHoraAtual().get("Segundo"));

		Calendar ca = new GregorianCalendar(1997, 6, 4, 20, 30, 40);
		System.out.println(ca.getTime());

		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		DependenteDAO dao = new DependenteDAOImpl(em);
		Dependente dependente = dao.pesquisar(51);

		System.out.println("");

		System.out.println(f.formataData(dependente.getDataNascimento()));
		System.out.println(f.formataData(dependente.getDataNascimento(), "dd/MM/yyyy"));

		System.out.println("");

		System.out.println(f.formataDataHora(dependente.getDataCriacao()));
		System.out.println(f.formataDataHora(dependente.getDataCriacao(), "dd/MM/yyyy hh:mm:ss"));

		System.out.println("");

		System.out.println(f.formataHora(dependente.getDataCriacao()));
		System.out.println(f.formataHora(dependente.getDataCriacao(), "hh|mm|ss"));

		em.close();

	}
}
