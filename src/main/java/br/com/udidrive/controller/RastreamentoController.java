package br.com.udidrive.controller;

import br.com.udidrive.service.RastreamentoService;
import br.com.udidrive.vo.RastreamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamento")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<RastreamentoVO> listarTodos() {
        return rastreamentoService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RastreamentoVO buscarPorId(@PathVariable(value = "id") Long id) {
        return rastreamentoService.buscarPorId(id);

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RastreamentoVO salvar(@RequestBody RastreamentoVO rastreamentoVO) {
        return rastreamentoService.salvar(rastreamentoVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RastreamentoVO update( @RequestBody RastreamentoVO rastreamentoVO) {
        return rastreamentoService.atualizar(rastreamentoVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        rastreamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}