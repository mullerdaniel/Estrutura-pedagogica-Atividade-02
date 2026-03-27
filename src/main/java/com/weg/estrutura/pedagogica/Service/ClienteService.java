package com.weg.estrutura.pedagogica.Service;

import com.weg.estrutura.pedagogica.Dto.Requisicao.ClienteRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.ClienteRespostaDto;
import com.weg.estrutura.pedagogica.Mapper.ClienteMapper;
import com.weg.estrutura.pedagogica.Model.Cliente;
import com.weg.estrutura.pedagogica.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository,
                          ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    public ClienteRespostaDto salvar(ClienteRequisicaoDto dto) {
        Cliente cliente = clienteMapper.toEntity(dto);
        cliente = clienteRepository.save(cliente);
        return clienteMapper.toDto(cliente);
    }

    public List<ClienteRespostaDto> listar() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public ClienteRespostaDto buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return clienteMapper.toDto(cliente);
    }

    public List<ClienteRespostaDto> buscarPorNome(String nome) {
        return clienteRepository.findByNome(nome)
                .stream()
                .map(clienteMapper::toDto)
                .toList();
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}