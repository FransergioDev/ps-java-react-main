package br.com.banco.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.banco.entity.ContaEntity;
import br.com.banco.entity.TransfereciaEntity;

public class TransferenciaDTO {
	
	private Long id;
	private java.sql.Timestamp dataTransferencia;
	private Float valor;
	private String tipo;
	private String nomeOperadorTransacao;
    private ContaEntity conta;

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

	public ContaEntity getConta() {
		return conta;
	}

	public void setConta(ContaEntity conta) {
		this.conta = conta;
	}
	

	public TransferenciaDTO() {
		super();
	}

	public TransferenciaDTO(Long id, Timestamp dataTransferencia, Float valor, String tipo,
			String nomeOperadorTransacao, ContaEntity conta) {
		super();
		this.id = id;
		this.dataTransferencia = dataTransferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nomeOperadorTransacao = nomeOperadorTransacao;
		this.conta = conta;
	}

	public TransferenciaDTO convert(TransfereciaEntity transfereciaEntity) {
		BeanUtils.copyProperties(transfereciaEntity, this, 
				"getId", 
				"getDataTransferencia",
				"getValor",
				"getTipo",
				"getNomeOperadorTransacao",
				"getConta"
			);
		return this;
	}
	
	public List<TransferenciaDTO> convertList(List<TransfereciaEntity> transfereciaEntity){
		List<TransferenciaDTO> transferenciaDTOLista = new ArrayList<>();
		transfereciaEntity.forEach(t -> transferenciaDTOLista.add(new TransferenciaDTO().convert(t)));
		return transferenciaDTOLista;
	}
}
