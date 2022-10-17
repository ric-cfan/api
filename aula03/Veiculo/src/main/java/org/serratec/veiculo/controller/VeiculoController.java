package org.serratec.veiculo.controller;

import java.util.ArrayList;
import java.util.List;

import org.serratec.veiculo.domain.Veiculo;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	private static List<Veiculo> lista = new ArrayList<>();
	static {
		lista.add(new Veiculo(1L, "Marca1", "Modelo1"));
		lista.add(new Veiculo(2L, "Marca2", "Modelo2"));
		lista.add(new Veiculo(3L, "Marca3", "Modelo3"));
	}

	@GetMapping
	public List<Veiculo> listar() {
		return lista;
	}

	@GetMapping("/{id}")
	public Veiculo buscar(@PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				return lista.get(i);
			}
		}
		return null;
	}

	@PostMapping
	public Veiculo inserir(@RequestBody Veiculo veiculo) {
		lista.add(veiculo);
		return veiculo;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				lista.remove(i);
				break;
			}
		}
	}

	@PutMapping("/{id}")
	public Veiculo atualizar(@RequestBody Veiculo veiculo, @PathVariable Long id) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).getId().equals(id)) {
				Veiculo v = new Veiculo(id, veiculo.getMarca(), veiculo.getModelo());
				lista.set(i, v);
				return v;
			}
		}
		return null;
	}

}
