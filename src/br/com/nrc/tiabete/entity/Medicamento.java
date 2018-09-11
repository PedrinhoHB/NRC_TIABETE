package br.com.nrc.tiabete.entity;

import java.io.Serializable;
import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")

@Entity(name = "Medicamento")
@Table(name = "T_NRC_MEDICAMENTO")
@SequenceGenerator(name = "medicamento", sequenceName = "SQ_T_NRC_MEDICAMENTO", allocationSize = 1)
public class Medicamento implements Serializable {
	@Id
	@Column(name = "cd_medicamento")
	@GeneratedValue(generator = "medicamento", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_remedio")
	private Remedio remedio;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_dependente")
	private Dependente dependente;

	@Column(name = "ds_periodo")
	private String periodo;

	@Column(name = "horario")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horario;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Calendar getHorario() {
		return horario;
	}

	public void setHorario(Calendar horario) {
		this.horario = horario;
	}

	public Remedio getRemedio() {
		return remedio;
	}

	public void setRemedio(Remedio remedio) {
		this.remedio = remedio;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

}
