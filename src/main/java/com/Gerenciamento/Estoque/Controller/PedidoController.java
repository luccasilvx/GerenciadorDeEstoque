package com.Gerenciamento.Estoque.Controller;

import com.Gerenciamento.Estoque.DTO.PedidoDto;
import com.Gerenciamento.Estoque.Models.Pedido;
import com.Gerenciamento.Estoque.Repository.PedidoRepository;
import com.Gerenciamento.Estoque.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService service;

    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDto dto){
        Pedido novoPedido = service.criarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }
}
