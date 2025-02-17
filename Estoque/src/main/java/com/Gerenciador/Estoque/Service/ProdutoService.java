package com.Gerenciador.Estoque.Service;

import com.Gerenciador.Estoque.DTO.ProdutoDto;
import com.Gerenciador.Estoque.Exceptions.ProductNotFoundException;
import com.Gerenciador.Estoque.Models.Produto;
import com.Gerenciador.Estoque.Repository.ProdutoRepository;
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

    public void removerProduto(Long numeroProduto){
        Produto produto = repository.findById(numeroProduto)
                .orElseThrow(()-> new ProductNotFoundException("O produto "+numeroProduto+" não foi encontrado com sucesso."));
        repository.delete(produto);
    }
}

