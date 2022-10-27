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

import br.org.serratec.biblioteca.domain.Associado;
import br.org.serratec.biblioteca.repository.AssociadoRepository;

@RestController
@RequestMapping("/api/associado")
public class AssociadoController {

	@Autowired
	private AssociadoRepository associadoRepository;

	@GetMapping
	public ResponseEntity<List<Associado>> buscar() {
		return ResponseEntity.ok(associadoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Associado> buscarPorId(@PathVariable Long id) {
		Optional<Associado> associado = associadoRepository.findById(id);
		if (!associado.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(associado.get());
	}

	@PostMapping
	public ResponseEntity<Associado> inserir(@Valid @RequestBody Associado associado) {
		associado = associadoRepository.save(associado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(associado.getId())
				.toUri();
		return ResponseEntity.created(uri).body(associado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Associado> atualizar(@PathVariable Long id, @Valid @RequestBody Associado associado) {
		Optional<Associado> associadoBanco = associadoRepository.findById(id);
		if (!associadoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		associado.setId(id);
		associado = associadoRepository.save(associado);
		return ResponseEntity.ok(associado);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		Optional<Associado> associadoBanco = associadoRepository.findById(id);
		if (!associadoBanco.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		associadoRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
