package br.org.serratec.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.projeto.domain.UsuarioPerfil;
import br.org.serratec.projeto.domain.UsuarioPerfilPK;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UsuarioPerfilPK> {
}