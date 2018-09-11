package br.com.nrc.tiabete.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity(name = "Aplicacao")
@Table(name = "T_NRC_APLICACAO")
@SequenceGenerator(name = "aplicacao", sequenceName = "SQ_T_NRC_APLICACAO", allocationSize = 1)
public class Aplicacao implements Serializable {

	@Id
	@Column(name = "cd_aplicacao")
	@GeneratedValue(generator = "aplicacao", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_insulina")
	private Insulina insulina;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_usuario")
	private Dependente dependente;

	@Column(name = "vl_escala", length = 150)
	private double valorEscala;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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

	public double getValorEscala() {
		return valorEscala;
	}

	public void setValorEscala(double valorEscala) {
		this.valorEscala = valorEscala;
	}

}
