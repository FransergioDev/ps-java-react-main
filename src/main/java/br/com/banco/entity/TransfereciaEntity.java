package br.com.banco.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name = "transferencia")
@Entity(name = "transferencia")
public class TransfereciaEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "data_transferencia")
    @JsonProperty("data_transferencia")
	private java.sql.Timestamp dataTransferencia;
	
	@Column(name = "valor")
	private Float valor;

	@Column(name = "tipo")
    @JsonProperty("tipo")
	private String tipo;
	
	
	@Column(name = "nome_operador_transacao")
    @JsonProperty("nome_operador_transacao")
	private String nomeOperadorTransacao;


	@OneToOne(cascade = CascadeType.ALL, optional = false)
	@JoinColumn(name = "conta_id", referencedColumnName = "id_conta")
    private ContaEntity contaEntity;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public java.sql.Timestamp getDataTransferencia() {
		return dataTransferencia;
	}


	public void setDataTransferencia(java.sql.Timestamp dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}


	public Float getValor() {
		return valor;
	}


	public void setValor(Float valor) {
		this.valor = valor;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNomeOperadorTransacao() {
		return nomeOperadorTransacao;
	}


	public void setNomeOperadorTransacao(String nomeOperadorTransacao) {
		this.nomeOperadorTransacao = nomeOperadorTransacao;
	}


	public ContaEntity getContaEntity() {
		return contaEntity;
	}


	public void setContaEntity(ContaEntity contaEntity) {
		this.contaEntity = contaEntity;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
