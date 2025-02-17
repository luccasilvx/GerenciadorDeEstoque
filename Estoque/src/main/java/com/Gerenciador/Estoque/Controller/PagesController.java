package com.Gerenciador.Estoque.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    //arquivos dentro de templates

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/criarPedido")
    public String criarPedido() {
        return "criarPedido";
    }

    @GetMapping("/listarPedidos")
    public String listarPedidos() {
        return "listarPedidos";
    }

    @GetMapping("/atualizarStatus")
    public String atualizarStatus() {
        return "atualizarStatus";
    }

    @GetMapping("/gerarRelatorio")
    public String gerarRelatorio() {
        return "gerarRelatorio";
    }

    @GetMapping("/cadastrarProduto")
    public String cadastrarProduto() {
        return "cadastrarProduto";
    }

    @GetMapping("/listarProdutos")
    public String listarProdutos() {
        return "listarProdutos";
    }

    @GetMapping("/removerProduto")
    public String removerProduto() {
        return "removerProduto";
    }

    @GetMapping("/cancelarPedido")
    public String cancelarPedido() {
        return "cancelarPedido";
    }
}

