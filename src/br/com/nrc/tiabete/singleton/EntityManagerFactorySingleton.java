package br.com.nrc.tiabete.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {

	// 1- Construtor privado
	private EntityManagerFactorySingleton() {
	}

	// 2- Atributo estático
	private static EntityManagerFactory fabrica;

	// 3- Método estático
	public static EntityManagerFactory getInstance() {
		if (fabrica == null) {
			fabrica = Persistence.createEntityManagerFactory("oracle");
		}
		return fabrica;
	}

}
