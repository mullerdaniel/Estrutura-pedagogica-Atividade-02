package com.weg.estrutura.pedagogica.Service;

import com.weg.estrutura.pedagogica.Dto.Requisicao.PedidoRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.PedidoRespostaDto;
import com.weg.estrutura.pedagogica.Mapper.PedidoMapper;
import com.weg.estrutura.pedagogica.Model.Cliente;
import com.weg.estrutura.pedagogica.Model.Pedido;
import com.weg.estrutura.pedagogica.Repository.ClienteRepository;
import com.weg.estrutura.pedagogica.Repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.pedidoMapper = pedidoMapper;
    }

    public PedidoRespostaDto salvar(PedidoRequisicaoDto dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Pedido pedido = pedidoMapper.toEntity(dto, cliente);
        pedido = pedidoRepository.save(pedido);

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoRespostaDto> listar() {
        return pedidoRepository.findAll()
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public PedidoRespostaDto buscarPorId(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoRespostaDto> buscarPorClienteId(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public List<PedidoRespostaDto> buscarPorNomeCliente(String nome) {
        return pedidoRepository.findByClienteNome(nome)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }

    public PedidoRespostaDto buscarPorIdEDescricao(Long id, String descricao) {
        Pedido pedido = pedidoRepository.findByIdAndDescricao(id, descricao)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.toDto(pedido);
    }

    public List<PedidoRespostaDto> buscarPorClienteOrdenado(Long clienteId) {
        return pedidoRepository.findByClienteIdOrderByIdAsc(clienteId)
                .stream()
                .map(pedidoMapper::toDto)
                .toList();
    }
}