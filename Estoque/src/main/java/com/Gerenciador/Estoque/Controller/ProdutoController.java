package com.Gerenciador.Estoque.Controller;

import com.Gerenciador.Estoque.DTO.ProdutoDto;
import com.Gerenciador.Estoque.Models.Produto;
import com.Gerenciador.Estoque.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping("/produtos")
    public ResponseEntity<Produto> cadastrarProduto(ProdutoDto dto){
        Produto produtoCadastrado = service.cadastrarProduto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.ok(service.listarProdutos());
    }

    @DeleteMapping("/produtos/{numeroProduto}")
    public ResponseEntity<Void> removerProduto(@PathVariable Long numeroProduto){
        service.removerProduto(numeroProduto);
        return ResponseEntity.noContent().build();
    }
}

