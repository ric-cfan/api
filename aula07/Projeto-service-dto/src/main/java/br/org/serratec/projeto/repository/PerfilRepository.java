package br.org.serratec.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.projeto.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
