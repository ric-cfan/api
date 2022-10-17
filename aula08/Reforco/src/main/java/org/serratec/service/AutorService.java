package org.serratec.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.domain.Autor;
import org.serratec.dto.AutorDTO;
import org.serratec.dto.AutorCountDTO;
import org.serratec.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
	@Autowired
	private AutorRepository autorRepository;
	
	public List<AutorDTO> buscaTodos() {
		List<Autor> autores = autorRepository.findAll();
		List<AutorDTO> autoresDTO = new ArrayList<>();
		 for (Autor autor : autores) {
			autoresDTO.add(new AutorDTO(autor));
		}
		 return autoresDTO;
	}
	
	public List<AutorCountDTO> totalLivros() {
		List<Autor> autores = autorRepository.findAll();
		List<AutorCountDTO> autoresDTO = new ArrayList<>();
		 for (Autor autor : autores) {
			autoresDTO.add(new AutorCountDTO(autor));
		}
		 return autoresDTO;
	}
	
}
