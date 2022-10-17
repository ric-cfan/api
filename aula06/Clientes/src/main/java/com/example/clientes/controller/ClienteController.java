package com.example.clientes.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.clientes.domain.Cliente;
import com.example.clientes.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente inserir(@Valid @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		cliente.setId(id);
		cliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(cliente);
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @Valid @PathVariable Long id) {
//		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
//		if (!clienteOptional.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		Cliente clienteNovo = clienteOptional.get();
//		clienteNovo.setCpf(cliente.getCpf());
//		clienteNovo.setEmail(cliente.getEmail());
//		clienteNovo.setNome(cliente.getNome());
//		clienteNovo = clienteRepository.save(clienteNovo);
//		return ResponseEntity.ok(clienteNovo);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}