package com.Gerenciador.Estoque.Service;

import com.Gerenciador.Estoque.DTO.PedidoDto;
import com.Gerenciador.Estoque.Exceptions.PedidoNotFoundException;
import com.Gerenciador.Estoque.Models.Pedido;
import com.Gerenciador.Estoque.Models.Status;
import com.Gerenciador.Estoque.Repository.PagePedidosRepository;
import com.Gerenciador.Estoque.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private PagePedidosRepository PageRepository;

    public Pedido criarPedido(PedidoDto dto){
        Pedido pedido = new Pedido();
        pedido.setClienteNome(dto.getClienteNome());
        pedido.setClienteEmail(dto.getClienteEmail());
        pedido.setProduto(dto.getNomeProduto());
        pedido.setStatus(dto.getStatus() != null ? dto.getStatus() : Status.PENDENTE);// define status ou usa padrão
        pedido.setDataPedido(LocalDateTime.now());

        BigDecimal total = dto.getNomeProduto().stream()
                .map(produto -> produto.getPreco())
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        pedido.setTotal(total);

        return repository.save(pedido);
    }

    public Page<Pedido> listarPedidosPaginados(Status status,
                                               LocalDateTime dataPedido,
                                               int pagina,
                                               int itens){
        Pageable pageable = PageRequest.of(pagina,itens);
        if (status!= null && dataPedido != null){
            return repository.findByStatusAndDataPedido(status,dataPedido,pageable);
        } else if (status != null){
            return repository.findByStatus(status,pageable);
        } else if (dataPedido != null) {
            return repository.findByDataPedido(dataPedido,pageable);
        }
        return repository.findAll(pageable);
    }

    public Pedido atualizarStatusPedido(Long numeroPedido, Status novoStatus){
        Pedido pedido = repository.findById(numeroPedido)
                .orElseThrow(()-> new PedidoNotFoundException("Pedido não encontrado.")
                );
        pedido.setStatus(novoStatus);
        return repository.save(pedido);
    }

    public void cancelarPedido(Long numeroPedido){
        Pedido pedido = repository.findById(numeroPedido)
                .orElseThrow(()->new RuntimeException("O pedido "+numeroPedido+" não foi encontrada com sucesso."));
        repository.delete(pedido);
    }
}

