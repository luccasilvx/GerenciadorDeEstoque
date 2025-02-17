package com.Gerenciador.Estoque.Repository;

import com.Gerenciador.Estoque.Models.Pedido;
import com.Gerenciador.Estoque.Models.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Page<Pedido> findByStatus(Status status, Pageable pageable);
    Page<Pedido> findByDataPedido(LocalDateTime dataPedido, Pageable pageable);
    Page<Pedido> findByStatusAndDataPedido(Status status, LocalDateTime dataPedido, Pageable pageable);
}
