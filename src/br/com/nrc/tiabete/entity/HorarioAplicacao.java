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

@Entity(name = "HorarioAplicacao")
@Table(name = "T_NRC_HORARIO_APLICACAO")
@SequenceGenerator(name = "horarioAplicacao", sequenceName = "SQ_T_NRC_HORA_APLICACAO", allocationSize = 1)
public class HorarioAplicacao implements Serializable {

	@Id
	@GeneratedValue(generator = "horarioAplicacao", strategy = GenerationType.SEQUENCE)
	@Column(name = "vl_escala", length = 150)
	private int codigo;

	@Column(name = "hora_aplicacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar horaAplicacao;

	@Column(name = "vl_dose")
	private double dose;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_aplicacao")
	private Aplicacao aplicacao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getHoraAplicacao() {
		return horaAplicacao;
	}

	public void setHoraAplicacao(Calendar horaAplicacao) {
		this.horaAplicacao = horaAplicacao;
	}

	public double getDose() {
		return dose;
	}

	public void setDose(double dose) {
		this.dose = dose;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

}
