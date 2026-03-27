package com.weg.estrutura.pedagogica.Dto.Requisicao;

import java.util.List;

public record ClienteRequisicaoDto(
        String nome,
        List<Long> pedidosIds
){
}