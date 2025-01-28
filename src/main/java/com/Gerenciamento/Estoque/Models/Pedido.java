package com.Gerenciamento.Estoque.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "Estoque")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroPedido;

    @JsonProperty("clienteNome")
    private String clienteNome;

    @JsonProperty("clienteEmail")
    private String clienteEmail;

    @JsonProperty("dataPedido")
    private LocalDateTime dataPedido;

    @JoinTable(
            name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<Produto> produto;
}
