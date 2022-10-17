package br.org.serratec.projeto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.projeto.domain.Perfil;
import br.org.serratec.projeto.domain.Usuario;
import br.org.serratec.projeto.domain.UsuarioPerfil;
import br.org.serratec.projeto.dto.UsuarioDTO;
import br.org.serratec.projeto.dto.UsuarioInserirDTO;
import br.org.serratec.projeto.exception.EmailException;
import br.org.serratec.projeto.exception.SenhaException;
import br.org.serratec.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<UsuarioDTO> lista() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for (int i = 0; i < usuarios.size(); i++) {
			Usuario usuario = usuarios.get(i);
			usuariosDTO.add(new UsuarioDTO(usuario));
		}

		// return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
		return usuariosDTO;
	}

	@Autowired
	private PerfilService perfilService;

	@Transactional
	public UsuarioDTO inserir(UsuarioInserirDTO user) throws EmailException {
		if (!user.getSenha().equalsIgnoreCase(user.getConfirmaSenha())) {
			throw new SenhaException("Senha e Confirma Senha não são iguais");
		}
		if (usuarioRepository.findByEmail(user.getEmail()) != null) {
			throw new EmailException("Email já existente");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(user.getNome());
		usuario.setEmail(user.getEmail());
		usuario.setSenha(user.getSenha());
		Set<UsuarioPerfil> perfis = new HashSet<>();
		for (Perfil perfil : user.getPerfis()) {
			perfil = perfilService.buscar(perfil.getId());
			UsuarioPerfil usuarioPerfil = new UsuarioPerfil(usuario, perfil, LocalDate.now());
			perfis.add(usuarioPerfil);
		}
		usuario.setUsuarioPerfis(perfis);
		usuario = usuarioRepository.save(usuario);
		return new UsuarioDTO(usuario);
	}

}