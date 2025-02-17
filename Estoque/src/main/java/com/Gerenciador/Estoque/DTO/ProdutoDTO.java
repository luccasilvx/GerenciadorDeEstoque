package com.Gerenciador.Estoque.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProdutoDto {

    @NotEmpty(message = "o nome não pode estar vazio")
    private String nomeProduto;

    @NotEmpty(message = "O produto deve possui uma descrição breve")
    @Size(min = 10, max = 255, message = "A restrição é de 255 caracteres")
    private String descricao;

    @NotBlank(message = "O valor não pode ser nulo, vazio ou espaços em branco")
    private BigDecimal preco;

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nome) {
        this.nomeProduto = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}