package br.com.banco.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.banco.dto.ContaDTO;
import br.com.banco.entity.ContaEntity;
import br.com.banco.service.ContaService;
import io.restassured.http.ContentType; 

@WebMvcTest
public class ContaControllerTest {
	@Autowired
	private ContaController contaController;
	
	@MockBean
	private ContaService contaService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.contaController);
	}
	
	@Test
	public void shouldReturnAListOfAccounts() {
		List<ContaDTO> contaList = new ArrayList<ContaDTO>();
		
		contaList.add(new ContaDTO().convert(new ContaEntity(1L, "João")));
		contaList.add(new ContaDTO().convert(new ContaEntity(2L, "André")));
		contaList.add(new ContaDTO().convert(new ContaEntity(3L, "Mariana")));
		
		when(this.contaService.getAll()).thenReturn(contaList);
		
		given()
			.accept(ContentType.ANY)
			.when().get("/conta")
			.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	
	/*@Test
	public void shouldReturnAListOfAccountsAsItSearchesByName() {
		List<ContaDTO> contaList = new ArrayList<ContaDTO>();
		
		contaList.add(new ContaDTO().convert(new ContaEntity(1L, "João")));
		
		when(this.contaService.searchByName("João")).thenReturn(contaList);
		
		given()
			.accept(ContentType.JSON)
			.when().get("/conta/searchByName?nomeResponsavel=João")
			.then()
			.statusCode(HttpStatus.OK.value());
	}*/
	
}
