package com.Gerenciamento.Estoque.Repository;

import com.Gerenciamento.Estoque.Models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
