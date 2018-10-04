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

@SuppressWarnings("serial")

@Entity(name = "ValorGlicemico")
@Table(name = "T_NRC_VALOR_GLICEMICO")
@SequenceGenerator(name = "valorGlicemico", sequenceName = "SQ_T_NRC_VALOR_GLICEMICO", allocationSize = 1)
public class ValorGlicemico implements Serializable {

	@Id
	@GeneratedValue(generator = "valorGlicemico", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_valor_glicemico")
	private int codigo;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "cd_usuario")
	private Dependente dependente;

	@Column(name = "ds_valor_glicemico", length = 150)
	private String descricao;

	@Column(name = "ds_hora")
	private Calendar hora;

	@Column(name = "vl_medicao")
	private double medicao;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public double getMedicao() {
		return medicao;
	}

	public void setMedicao(double medicao) {
		this.medicao = medicao;
	}

	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

}
