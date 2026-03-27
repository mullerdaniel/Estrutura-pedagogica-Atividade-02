package com.weg.estrutura.pedagogica.Mapper;


import com.weg.estrutura.pedagogica.Dto.Requisicao.PedidoRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.PedidoRespostaDto;
import com.weg.estrutura.pedagogica.Model.Cliente;
import com.weg.estrutura.pedagogica.Model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    // DTO → Entity
    public Pedido toEntity(PedidoRequisicaoDto dto, Cliente cliente) {
        Pedido pedido = new Pedido();
        pedido.setDescricao(dto.descricao());
        pedido.setCliente(cliente); // já validado no service
        return pedido;
    }

    // Entity → DTO
    public PedidoRespostaDto toDto(Pedido pedido) {
        PedidoRespostaDto pedidoRespostaDto = new PedidoRespostaDto(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getCliente().getId(),
                pedido.getCliente().getNome()
        );
        return pedidoRespostaDto;
    }
}