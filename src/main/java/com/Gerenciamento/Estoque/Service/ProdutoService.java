package com.Gerenciamento.Estoque.Service;

import com.Gerenciamento.Estoque.DTO.ProdutoDto;
import com.Gerenciamento.Estoque.Exceptions.ProductNotFoundException;
import com.Gerenciamento.Estoque.Models.Produto;
import com.Gerenciamento.Estoque.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto cadastrarProduto(ProdutoDto dto){
        Produto produto = new Produto();
        produto.setNomeProduto(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        return repository.save(produto);
    }

    public List<Produto> listarProdutos(){
        try {
            List<Produto> produtos = repository.findAll();
            if (produtos.isEmpty()){
                throw new ProductNotFoundException("Nenhum produto encontrado");
            }
            return produtos;
        }catch (RuntimeException e){
            throw new RuntimeException("Erro ao tentar listar produtos.", e);
        }
    }
}
