package br.com.nrc.tiabete.dao.test;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.nrc.tiabete.dao.MedicamentoDAO;
import br.com.nrc.tiabete.dao.impl.MedicamentoDAOImpl;
import br.com.nrc.tiabete.entity.Dependente;
import br.com.nrc.tiabete.entity.Medicamento;
import br.com.nrc.tiabete.entity.Remedio;
import br.com.nrc.tiabete.exception.CommitException;
import br.com.nrc.tiabete.singleton.EntityManagerFactorySingleton;
import br.com.nrc.tiabete.util.DataCalendar;

public class MedicamentoTeste {
	public static void main(String[] args) throws CommitException {
		EntityManager em = EntityManagerFactorySingleton
				.getInstance().createEntityManager();
		
		MedicamentoDAO dao = new MedicamentoDAOImpl(em);
		Medicamento medicamento = new Medicamento();
		
		
		Dependente dependente = new Dependente();
		Remedio remedio = new Remedio();
		
		DataCalendar dc = new DataCalendar();
		
		
		medicamento.setDependente(dependente);
		medicamento.setPeriodo("Diurno");
		medicamento.setHorario((new GregorianCalendar(dc.getDataHoraAtual()
				.get("Ano"),dc.getDataHoraAtual().get("Mes"),dc.getDataHoraAtual().get("Dia")
				,20,18,00)));
		medicamento.setRemedio(remedio);
		
		dao.inserir(medicamento);
		dao.commit();
		em.close();
		
	}
}
