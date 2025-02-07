package br.com.udidrive.controller;

import br.com.udidrive.service.PedidoService;
import br.com.udidrive.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<PedidoVO> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PedidoVO buscarPorId(@PathVariable(value = "id") Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PedidoVO salvar(@RequestBody PedidoVO pedidoVO) {
        return pedidoService.salvar(pedidoVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PedidoVO atualizar(@RequestBody PedidoVO pedidoVO) {
        return pedidoService.atualizar(pedidoVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
