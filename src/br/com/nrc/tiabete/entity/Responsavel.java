package br.com.nrc.tiabete.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@SuppressWarnings("serial")

@Entity(name = "Responsavel")
@Table(name = "T_NRC_RESPONSAVEL")
@PrimaryKeyJoinColumn(name = "cd_usuario")
public class Responsavel extends Usuario implements Serializable {
	@Column(name = "ds_telefone")
	private String telefone;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
