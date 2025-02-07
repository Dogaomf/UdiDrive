package br.com.udidrive.controller;

import br.com.udidrive.model.Cliente;
import br.com.udidrive.service.ClienteService;
import br.com.udidrive.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ClienteVO> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClienteVO buscarPorId(@PathVariable(value = "id") Long id) {
        return clienteService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClienteVO salvar(@RequestBody ClienteVO clienteVO) {
        return clienteService.salvar(clienteVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ClienteVO atualizar(@RequestBody ClienteVO clienteVO) {
        return clienteService.atualizar(clienteVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
