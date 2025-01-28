package com.Gerenciamento.Estoque.Service;

import com.Gerenciamento.Estoque.DTO.PedidoDto;
import com.Gerenciamento.Estoque.Models.Pedido;
import com.Gerenciamento.Estoque.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido criarPedido(PedidoDto dto){
        Pedido pedido = new Pedido();
        pedido.setClienteNome(dto.getClienteNome());
        pedido.setClienteEmail(dto.getClienteEmail());
        pedido.setProduto(dto.getNomeProduto());

        return repository.save(pedido);
    }
}
