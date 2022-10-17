package org.serratec.heranca.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.serratec.heranca.domain.Gerente;
import org.serratec.heranca.repository.FuncionarioRepository;
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

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public List<Gerente> listar() {
		return funcionarioRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Gerente> buscar(@PathVariable Long id) {
		Optional<Gerente> funcionario = funcionarioRepository.findById(id);
		if (funcionario.isPresent()) {
			return ResponseEntity.ok(funcionario.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Gerente inserir(@Valid @RequestBody Gerente gerente) {
		return funcionarioRepository.save(gerente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Gerente> atualizar(@PathVariable Long id, @Valid @RequestBody Gerente funcionario) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionario.setId(id);
		funcionario = funcionarioRepository.save(funcionario);
		return ResponseEntity.ok(funcionario);
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente, @Valid @PathVariable Long id) {
//		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
//		if (!clienteOptional.isPresent()) {
//			return ResponseEntity.notFound().build();
//		}
//		Cliente clienteNovo = clienteOptional.get();
//		clienteNovo.setid(cliente.getid());
//		clienteNovo.setEmail(cliente.getEmail());
//		clienteNovo.setNome(cliente.getNome());
//		clienteNovo = clienteRepository.save(clienteNovo);
//		return ResponseEntity.ok(clienteNovo);
//	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!funcionarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		funcionarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
