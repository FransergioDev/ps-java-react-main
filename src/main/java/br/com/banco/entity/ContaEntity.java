package br.com.banco.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "conta")
@Entity(name = "conta")
public class ContaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ContaEntity() {}
	public ContaEntity(Long id, String nomeResponsavel) {
		this.id = id;
		this.nomeResponsavel = nomeResponsavel;
	}

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id_conta")
    @JsonProperty("id_conta")
	private Long id;

	@Column(name = "nome_responsavel")
    @JsonProperty("nome_responsavel")
	private String nomeResponsavel;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeResponsavel() {
		return nomeResponsavel;
	}
	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
