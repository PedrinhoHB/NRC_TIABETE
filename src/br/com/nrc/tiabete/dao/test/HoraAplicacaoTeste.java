package br.com.nrc.tiabete.dao.test;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.HorarioAplicacaoDAO;
import br.com.nrc.tiabete.dao.impl.HorarioAplicacaoDAOImpl;
import br.com.nrc.tiabete.entity.Aplicacao;
import br.com.nrc.tiabete.entity.HorarioAplicacao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;
import br.com.nrc.tiabete.util.DataCalendar;

public class HoraAplicacaoTeste {
	
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		
		Aplicacao aplicacao= new Aplicacao();
		
		HorarioAplicacaoDAO dao = new HorarioAplicacaoDAOImpl(em);
		HorarioAplicacao horarioAplicacao = new HorarioAplicacao();
		
		
		horarioAplicacao.setDose(2.0);
		
		DataCalendar dc = new DataCalendar();
		horarioAplicacao.setHoraAplicacao(new GregorianCalendar(dc.getDataHoraAtual()
				.get("Ano"),dc.getDataHoraAtual().get("Mes"),dc.getDataHoraAtual().get("Dia")
				,20,18,00)); 
		horarioAplicacao.setAplicacao(aplicacao); 
		
		dao.inserir(horarioAplicacao);
		dao.commit();

		em.close();
		
		
	}
}
