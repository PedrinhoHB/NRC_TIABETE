package br.com.nrc.tiabete.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity(name = "ResponsavelDependente")
@Table(name = "T_NRC_RESPONSAVEL_DEPENDETNE")
@IdClass(ResponsavelDependentePK.class)
public class ResponsavelDependente implements Serializable {
	@Id
	@JoinColumn(name = "cd_responsavel")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Responsavel responsavel;

	@Id
	@JoinColumn(name = "cd_dependente")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Dependente dependente;

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}
}
