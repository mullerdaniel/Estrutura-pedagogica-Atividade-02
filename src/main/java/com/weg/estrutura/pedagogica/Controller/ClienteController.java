package com.weg.estrutura.pedagogica.Controller;

import com.weg.estrutura.pedagogica.Dto.Requisicao.ClienteRequisicaoDto;
import com.weg.estrutura.pedagogica.Dto.Resposta.ClienteRespostaDto;
import com.weg.estrutura.pedagogica.Service.ClienteService;
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
    public ClienteRespostaDto salvar(@RequestBody ClienteRequisicaoDto dto) {
        return clienteService.salvar(dto);
    }

    @GetMapping
    public List<ClienteRespostaDto> listar() {
        return clienteService.listar();
    }

    @GetMapping("/{id}")
    public ClienteRespostaDto buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    @GetMapping("/nome")
    public List<ClienteRespostaDto> buscarPorNome(@RequestParam String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        clienteService.deletar(id);
    }
}