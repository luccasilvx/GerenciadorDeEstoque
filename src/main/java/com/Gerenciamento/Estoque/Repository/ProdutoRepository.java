package com.Gerenciamento.Estoque.Repository;

import com.Gerenciamento.Estoque.Models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
