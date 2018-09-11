package br.com.nrc.tiabete.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity(name = "Alimento")
@Table(name = "T_NRC_ALIMENTO")
@SequenceGenerator(name = "alimento", sequenceName = "SQ_T_NRC_ALIMENTO", allocationSize = 1)
public class Alimento implements Serializable {
	@Id
	@Column(name = "cd_alimento")
	@GeneratedValue(generator = "alimento", strategy = GenerationType.SEQUENCE)
	private int codigo;

	@Column(name = "nm_alimento")
	private String nome;

	@Column(name = "vl_carbohidrato")
	private double carbohidrato;

	@Column(name = "vl_carga_glicemica")
	private double cargaGlicemica;

	@Column(name = "ds_unidade_medida")
	private String unidadeMedida;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCarbohidrato() {
		return carbohidrato;
	}

	public void setCarbohidrato(double carbohidrato) {
		this.carbohidrato = carbohidrato;
	}

	public double getCargaGlicemica() {
		return cargaGlicemica;
	}

	public void setCargaGlicemica(double cargaGlicemica) {
		this.cargaGlicemica = cargaGlicemica;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}
