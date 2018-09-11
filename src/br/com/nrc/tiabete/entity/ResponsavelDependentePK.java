package br.com.nrc.tiabete.entity;

import java.io.Serializable;

@SuppressWarnings("serial")

public class ResponsavelDependentePK implements Serializable {

	private int responsavel;

	private int dependente;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dependente;
		result = prime * result + responsavel;
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
		ResponsavelDependentePK other = (ResponsavelDependentePK) obj;
		if (dependente != other.dependente)
			return false;
		if (responsavel != other.responsavel)
			return false;
		return true;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	public int getDependente() {
		return dependente;
	}

	public void setDependente(int dependente) {
		this.dependente = dependente;
	}
}
