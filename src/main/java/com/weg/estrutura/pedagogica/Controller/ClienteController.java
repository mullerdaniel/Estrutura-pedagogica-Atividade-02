package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Requisicao.ClienteRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.ClienteRespostaDto;
import com.weg.estrutura.pedagogica.Service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteRespostaDto> salvar(@RequestBody ClienteRequisicaoDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clienteService.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteRespostaDto>> listar() {
        return ResponseEntity.ok(clienteService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteRespostaDto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping("/nome")
    public ResponseEntity<List<ClienteRespostaDto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(clienteService.buscarPorNome(nome));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}