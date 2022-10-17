package org.serratec.heranca.repository;

import org.serratec.heranca.domain.Gerente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Gerente,Long>{

}
