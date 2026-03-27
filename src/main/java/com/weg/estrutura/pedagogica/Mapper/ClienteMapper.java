package com.weg.estrutura.pedagogica.Mapper;

import com.weg.estrutura.pedagogica.Dto.Requisicao.ClienteRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.ClienteRespostaDto;
import com.weg.estrutura.pedagogica.Model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toEntity(ClienteRequisicaoDto dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.nome());
        return cliente;
    }

    public ClienteRespostaDto toDto(Cliente cliente) {
        return new ClienteRespostaDto(
                cliente.getId(),
                cliente.getNome()
        );
    }
}