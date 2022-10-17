package org.serratec.controller;

import java.util.List;

import org.serratec.dto.AutorCountDTO;
import org.serratec.dto.AutorDTO;
import org.serratec.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/autores")
public class AutorController {
	@Autowired
	AutorService autorService;
	
	@GetMapping
	@ApiOperation(value = "Lista todos os autores", notes = "Listagem de autores")
	@ApiResponses(value = { 
			@ApiResponse(code = 404, message = "Autores não encontrados") 
	})
	public ResponseEntity<List<AutorDTO>> buscaTodos() {
		List<AutorDTO> autoresDTO = autorService.buscaTodos();
		if (autoresDTO.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(autoresDTO);
	}
	
	@GetMapping("/livros")
	@ApiOperation(value = "Mostra a quantidade de livros de cada autor", notes = "Contagem de livros por autor")
	@ApiResponses(value = { 
			@ApiResponse(code = 404, message = "Autores não encontrados") 
	})
	public ResponseEntity<List<AutorCountDTO>> totalLivros() {
		List<AutorCountDTO> autoresDTO = autorService.totalLivros();
		if (autoresDTO.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(autoresDTO);
	}
	

}
