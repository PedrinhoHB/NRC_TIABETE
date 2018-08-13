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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "InsulinaDependente")
@Table(name = "T_NRC_INSULINA_DEPENDENTE")
@IdClass(InsulinaDependentePK.class)
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class InsulinaDependente implements Serializable {
	@Id
	@JoinColumn(name = "cd_insulina")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Insulina insulina;

	@Id
	@JoinColumn(name = "cd_dependente")
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Dependente dependente;

	public Insulina getInsulina() {
		return insulina;
	}

	public void setInsulina(Insulina insulina) {
		this.insulina = insulina;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}
}