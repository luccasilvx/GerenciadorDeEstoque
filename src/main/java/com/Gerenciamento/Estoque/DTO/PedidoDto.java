package com.Gerenciamento.Estoque.DTO;

import com.Gerenciamento.Estoque.Models.Produto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class PedidoDto {
    @NotEmpty(message = "o nome não pode estar vazio")
    private String clienteNome;

    @Email(message = "e-mail deve ser válido")
    private String clienteEmail;

    @NotEmpty(message = "Tem que possuir no mínimo um produto")
    private String nomeProduto;

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public List<Produto> getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(List<Produto> nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}
