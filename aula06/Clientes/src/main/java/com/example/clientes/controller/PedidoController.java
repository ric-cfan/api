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

import com.example.clientes.domain.Pedido;
import com.example.clientes.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public List<Pedido> listar() {
		return pedidoRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		if (pedido.isPresent()) {
			return ResponseEntity.ok(pedido.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido inserir(@Valid @RequestBody Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

}