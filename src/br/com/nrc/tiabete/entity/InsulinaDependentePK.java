package br.com.nrc.tiabete.entity;

import java.io.Serializable;

@SuppressWarnings("serial")

public class InsulinaDependentePK implements Serializable {

	private int insulina;

	private int dependente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dependente;
		result = prime * result + insulina;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsulinaDependentePK other = (InsulinaDependentePK) obj;
		if (dependente != other.dependente)
			return false;
		if (insulina != other.insulina)
			return false;
		return true;
	}

	public int getInsulina() {
		return insulina;
	}

	public void setInsulina(int insulina) {
		this.insulina = insulina;
	}

	public int getDependente() {
		return dependente;
	}

	public void setDependente(int dependente) {
		this.dependente = dependente;
	}
}
