package br.com.banco.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.repository.TransferenciaRepository;



@Service
public class TransferenciaService {
	final TransferenciaRepository transferenciaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository) {
        this.transferenciaRepository = transferenciaRepository;
    }
	
	public List<TransferenciaDTO> getAll(){
		TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
		return transferenciaDTO.convertList(transferenciaRepository.findAll());
	}
	
	public List<TransferenciaDTO> searchByNameAccount(String name){
		//return transferenciaRepository.searchTransferOfAccountByName(name);
		var d = transferenciaRepository.searchTransferOfAccountByName(name);
		if (d.size() > 0) {
			System.out.println("id:" + d.get(1).getId() + " - nomeOperadorTransacao:" + d.get(1).getNomeOperadorTransacao());	
		} else System.err.println("size 0 - for name:" + name);
		return d;
	}
}
