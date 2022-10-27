package br.org.serratec.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.serratec.biblioteca.domain.Associado;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado,Long>{

}
