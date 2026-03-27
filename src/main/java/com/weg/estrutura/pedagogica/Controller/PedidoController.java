package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Requisicao.PedidoRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.PedidoRespostaDto;
import com.weg.estrutura.pedagogica.Service.PedidoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<PedidoRespostaDto> salvar(@RequestBody PedidoRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<PedidoRespostaDto>> listar() {
        return ResponseEntity.ok(pedidoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoRespostaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PedidoRespostaDto>> buscarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(pedidoService.buscarPorClienteId(clienteId));
    }

    @GetMapping("/cliente/nome")
    public ResponseEntity<List<PedidoRespostaDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(pedidoService.buscarPorNomeCliente(nome));
    }

    @GetMapping("/filtro")
    public ResponseEntity<PedidoRespostaDto> buscarPorIdEDescricao(
            @RequestParam Long id,
            @RequestParam String descricao) {
        return ResponseEntity.ok(pedidoService.buscarPorIdEDescricao(id, descricao));
    }

    @GetMapping("/cliente/{clienteId}/ordenado")
    public ResponseEntity<List<PedidoRespostaDto>> buscarOrdenado(@PathVariable Long clienteId) {
        return ResponseEntity.ok(pedidoService.buscarPorClienteOrdenado(clienteId));
    }
}