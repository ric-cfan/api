package com.example.clientes.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientes.domain.Documento;
import com.example.clientes.repository.DocumentoRepository;

@RestController
@RequestMapping("/documentos")
public class DocumentoController {
	@Autowired
	private DocumentoRepository documentoRepository;

	@GetMapping
	public List<Documento> listar() {
		return documentoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Documento> buscar(@PathVariable Long id) {
		Optional<Documento> documento = documentoRepository.findById(id);
		if (documento.isPresent()) {
			return ResponseEntity.ok(documento.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Documento inserir(@Valid @RequestBody Documento documento) {
		return documentoRepository.save(documento);
	}
}
