package com.example.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clientes.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}