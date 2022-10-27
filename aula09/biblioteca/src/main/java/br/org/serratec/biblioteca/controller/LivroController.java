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

import br.org.serratec.biblioteca.domain.Livro;
import br.org.serratec.biblioteca.repository.LivroRepository;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

	@Autowired
	private LivroRepository livroRepository;

	@GetMapping
	public ResponseEntity<List<Livro>> buscar() {
		return ResponseEntity.ok(livroRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
		Optional<Livro> livro = livroRepository.findById(id);
		if (!livro.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(livro.get());
	}

	@PostMapping
	public ResponseEntity<Livro> inserir(@Valid @RequestBody Livro livro) {
		livro = livroRepository.save(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(livro.getId())
				.toUri();
		return ResponseEntity.created(uri).body(livro);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, @Valid @RequestBody Livro livro) {
		Optional<Livro> livroBanco = livroRepository.findById(id);
		if (!livroBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		livro.setId(id);
		livro = livroRepository.save(livro);
		return ResponseEntity.ok(livro);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Livro> livroBanco = livroRepository.findById(id);
		if (!livroBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		livroRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
