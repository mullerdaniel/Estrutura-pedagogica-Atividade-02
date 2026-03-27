package com.weg.estrutura.pedagogica.Dto.Resposta;

import com.weg.estrutura.pedagogica.Model.Cliente;

public record PedidoRespostaDto(
        Long id,
        String descricao,
        Long clienteId,
        String clienteNome
) {
}
