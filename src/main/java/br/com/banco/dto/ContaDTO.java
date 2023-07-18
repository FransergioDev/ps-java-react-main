package br.com.banco.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import br.com.banco.entity.ContaEntity;

public class ContaDTO {
	private Long id;
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
	
	public ContaDTO(){
		super();
	}	
	
	public ContaDTO(Long id, String nomeResponsavel) {
		super();
		this.id = id;
		this.nomeResponsavel = nomeResponsavel;
	}

	public ContaDTO convert(ContaEntity contaEntity) {
		BeanUtils.copyProperties(contaEntity, this, "getId", "getNomeResponsavel");
		return this;
	}
	
	public List<ContaDTO> convertList(List<ContaEntity> listaContaEntity){
		List<ContaDTO> contaDTOLista = new ArrayList<>();
		listaContaEntity.forEach(c -> contaDTOLista.add(new ContaDTO().convert(c)));
		return contaDTOLista;
	}
}
