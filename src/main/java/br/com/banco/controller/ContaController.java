package br.com.banco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.ContaDTO;
import br.com.banco.service.ContaService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("conta")
public class ContaController {
	final ContaService contaService;

    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }
	
	@GetMapping
	public ResponseEntity<List<ContaDTO>> getAll() {
		return new ResponseEntity<List<ContaDTO>>(contaService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<List<ContaDTO>> searchByName(@RequestParam(value = "nomeResponsavel") String nomeResponsavel) {
		return new ResponseEntity<List<ContaDTO>>(contaService.searchByName(nomeResponsavel), HttpStatus.OK);
	}
	
}
