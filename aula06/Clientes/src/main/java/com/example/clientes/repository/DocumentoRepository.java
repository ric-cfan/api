package com.example.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clientes.domain.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
