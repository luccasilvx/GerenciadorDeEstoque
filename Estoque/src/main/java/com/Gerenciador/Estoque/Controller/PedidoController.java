package com.Gerenciador.Estoque.Controller;

import com.Gerenciador.Estoque.DTO.PedidoDto;
import com.Gerenciador.Estoque.Models.Pedido;
import com.Gerenciador.Estoque.Models.Status;
import com.Gerenciador.Estoque.Service.PedidoRelatorioService;
import com.Gerenciador.Estoque.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoRelatorioService relatorioService;

    @PostMapping("/pedido")
    public ResponseEntity<Pedido> criarPedido(@RequestBody PedidoDto dto){
        Pedido novoPedido = pedidoService.criarPedido(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPedido);
    }

    @GetMapping("/pedido")
    public ResponseEntity<Page<Pedido>> listarPedidosFiltrados(@RequestParam(required = false)Status status,
                                                               @RequestParam(required = false)LocalDateTime dataPedido,
                                                               @RequestParam(defaultValue = "0") int pagina,
                                                               @RequestParam(defaultValue = "10") int itens){
        return ResponseEntity.ok(pedidoService.listarPedidosPaginados(status, dataPedido,pagina, itens));
    }

    @PatchMapping("/pedido/{numeroPedido}/status")
    public ResponseEntity<Pedido> atualizarStatusPedido(@PathVariable Long numeroPedido,
                                                        @RequestBody Status novoStatus){
        Pedido pedidoAtualizado = pedidoService.atualizarStatusPedido(numeroPedido,novoStatus);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    @GetMapping("/pedido/relatorio")
    public ResponseEntity<byte[]> gerarRelatorio() throws IOException {
        byte[] pdf = relatorioService.gerarRelatorioPedidos();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=relatorio_pedidos.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

    @DeleteMapping("/pedido/{numeroPedido}")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long numeroPedido){
        pedidoService.cancelarPedido(numeroPedido);
        return ResponseEntity.noContent().build();
    }
}

