package com.Gerenciamento.Estoque.Controller;

import com.Gerenciamento.Estoque.DTO.ProdutoDto;
import com.Gerenciamento.Estoque.Models.Produto;
import com.Gerenciamento.Estoque.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
