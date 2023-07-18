package br.com.banco.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.dto.TransferenciaDTO;
import br.com.banco.service.TransferenciaService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("transferencia")
public class TransferenciaController {
	final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }
    
	@GetMapping
	public ResponseEntity<List<TransferenciaDTO>> getAll() {
		return new ResponseEntity<List<TransferenciaDTO>>(transferenciaService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/searchByName")
	public ResponseEntity<List<TransferenciaDTO>> searchByName(@RequestParam(value = "nomeResponsavel") String nomeResponsavel) {
		return new ResponseEntity<List<TransferenciaDTO>>(transferenciaService.searchByNameAccount(nomeResponsavel), HttpStatus.OK);
	}
}
