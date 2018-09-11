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

@Entity(name = "Refeicao")
@Table(name = "T_NRC_REFEICAO")
@SequenceGenerator(name = "refeicao", sequenceName = "SQ_T_NRC_REFEICAO", allocationSize = 1)
public class Refeicao implements Serializable {
	@Id
	@Column(name = "cd_refeicao")
	@GeneratedValue(generator = "refeicao", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_tipo_refeicao")
	private TipoRefeicao tipoRefeicao;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_alimento")
	private Alimento alimento;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_dependente")
	private Dependente dependente;

	@Column(name = "hora")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hora;

	@Column(name = "dt_refeicao")
	@Temporal(TemporalType.DATE)
	private Calendar dataRefeicao;

	@Column(name = "qt_refeicao")
	private int quantidadeRefeicao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoRefeicao getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTipoRefeicao(TipoRefeicao tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public Calendar getDataRefeicao() {
		return dataRefeicao;
	}

	public void setDataRefeicao(Calendar dataRefeicao) {
		this.dataRefeicao = dataRefeicao;
	}

	public int getQuantidadeRefeicao() {
		return quantidadeRefeicao;
	}

	public void setQuantidadeRefeicao(int quantidadeRefeicao) {
		this.quantidadeRefeicao = quantidadeRefeicao;
	}
}
