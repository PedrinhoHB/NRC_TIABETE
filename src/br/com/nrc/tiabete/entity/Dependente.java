package br.com.nrc.tiabete.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")

@Entity(name = "Dependente")
@Table(name = "T_NRC_DEP")
@PrimaryKeyJoinColumn(name = "cd_usuario")
public class Dependente extends Usuario implements Serializable {
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_tipo_diabete")
	private TipoDiabete tipoDiabete;

	@ManyToMany
	@JoinTable()
	private Set<Insulina> insulinas = new HashSet<Insulina>();

	@Column(name = "ds_genero")
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	@Column(name = "vl_peso")
	private double peso;

	@Column(name = "vl_altura")
	private double altura;

	@Column(name = "ds_medidor")
	private String medidor;

	@Column(name = "ds_modelo_medidor")
	private String modeloMedidor;

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getMedidor() {
		return medidor;
	}

	public void setMedidor(String medidor) {
		this.medidor = medidor;
	}

	public String getModeloMedidor() {
		return modeloMedidor;
	}

	public void setModeloMedidor(String modeloMedidor) {
		this.modeloMedidor = modeloMedidor;
	}

	public TipoDiabete getTipoDiabete() {
		return tipoDiabete;
	}

	public void setTipoDiabete(TipoDiabete tipoDiabete) {
		this.tipoDiabete = tipoDiabete;
	}
}
