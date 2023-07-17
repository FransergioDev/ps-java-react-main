package br.com.banco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.dto.ContaDTO;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {
	final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }
	
	public List<ContaDTO> getAll(){
		ContaDTO contaDTO = new ContaDTO();
		return contaDTO.convertList(contaRepository.findAll());
	}
	
	public List<ContaDTO> searchByName(String nomeResponsavel) {
		return contaRepository.searchByName(nomeResponsavel);
	}
}
