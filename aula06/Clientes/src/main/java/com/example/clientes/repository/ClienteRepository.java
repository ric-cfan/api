package com.example.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clientes.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{

}
