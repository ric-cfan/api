package br.org.serratec.biblioteca.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.serratec.biblioteca.domain.Emprestimo;
import br.org.serratec.biblioteca.repository.EmprestimoRepository;

@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	@GetMapping
	public ResponseEntity<List<Emprestimo>> buscar() {
		return ResponseEntity.ok(emprestimoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Long id) {
		Optional<Emprestimo> emprestimo = emprestimoRepository.findById(id);
		if (!emprestimo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(emprestimo.get());
	}

	@PostMapping
	public ResponseEntity<Emprestimo> inserir(@Valid @RequestBody Emprestimo emprestimo) {
		emprestimo = emprestimoRepository.save(emprestimo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emprestimo.getId())
				.toUri();
		return ResponseEntity.created(uri).body(emprestimo);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo> atualizar(@PathVariable Long id, @Valid @RequestBody Emprestimo emprestimo) {
		Optional<Emprestimo> emprestimoBanco = emprestimoRepository.findById(id);
		if (!emprestimoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		emprestimo.setId(id);
		emprestimo = emprestimoRepository.save(emprestimo);
		return ResponseEntity.ok(emprestimo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Emprestimo> emprestimoBanco = emprestimoRepository.findById(id);
		if (!emprestimoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		emprestimoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
