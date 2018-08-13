package br.com.nrc.tiabete.dao.test;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.ValorGlicemicoDAO;
import br.com.nrc.tiabete.dao.impl.ValorGlicemicoDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.ValorGlicemico;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;
import br.com.nrc.tiabete.util.DataCalendar;

public class ValorGlicemicoTeste {

	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		ValorGlicemicoDAO dao = new ValorGlicemicoDAOImpl(em);
		ValorGlicemico valorGlicemico = new ValorGlicemico();
		
		Dependente dependente = new Dependente();
		DataCalendar dc = new DataCalendar();
		
		
		
		valorGlicemico.setDependente(dependente);
		valorGlicemico.setDescricao("ta bom");
		valorGlicemico.setHora(new GregorianCalendar(dc.getDataHoraAtual()
				.get("Ano"),dc.getDataHoraAtual().get("Mes"),dc.getDataHoraAtual().get("Dia")
				,20,18,00));
		valorGlicemico.setMedicao(2.0);
		
		dao.inserir(valorGlicemico);
		dao.commit();

		em.close();
		
		
	}		
		
}
