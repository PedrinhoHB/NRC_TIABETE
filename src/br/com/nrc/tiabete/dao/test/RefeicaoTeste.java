package br.com.nrc.tiabete.dao.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.RefeicaoDAO;
import br.com.nrc.tiabete.dao.impl.RefeicaoDAOImpl;
import br.com.nrc.tiabete.entity.Alimento;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Refeicao;
import br.com.nrc.tiabete.entity.TipoRefeicao;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;
import br.com.nrc.tiabete.util.DataCalendar;

public class RefeicaoTeste {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		RefeicaoDAO dao = new RefeicaoDAOImpl(em);
		Refeicao refeicao = new Refeicao();
		
		
		DataCalendar dc = new DataCalendar();
		Alimento alimento = new Alimento();
		Dependente dependente = new Dependente();
		TipoRefeicao tipoRefeicao = new TipoRefeicao();
		
		refeicao.setAlimento(alimento);
		refeicao.setDataRefeicao((new GregorianCalendar(1998,Calendar.APRIL,27)));
		refeicao.setDependente(dependente);
		refeicao.setHora((new GregorianCalendar(dc.getDataHoraAtual()
				.get("Ano"),dc.getDataHoraAtual().get("Mes"),dc.getDataHoraAtual().get("Dia")
				,20,18,00)));
		refeicao.setQuantidadeRefeicao(40);
		refeicao.setTipoRefeicao(tipoRefeicao);
		
		dao.inserir(refeicao);
		dao.commit();

		em.close();
		
	}
}
