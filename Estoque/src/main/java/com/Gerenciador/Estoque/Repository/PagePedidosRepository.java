package com.Gerenciador.Estoque.Repository;

import com.Gerenciador.Estoque.Models.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagePedidosRepository extends JpaRepository<Pedido, Long> {
    Page<Pedido> findAll(Pageable pageable);
}
