package br.com.udidrive.controller;

import br.com.udidrive.service.PagamentoService;
import br.com.udidrive.vo.PagamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {
    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<PagamentoVO>listarTodos() {
        return pagamentoService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PagamentoVO buscarPorId(@PathVariable(value = "id") Long id) {
        return pagamentoService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PagamentoVO salvar(@RequestBody PagamentoVO pagamentoVO) {
        return pagamentoService.salvar(pagamentoVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public PagamentoVO atualizar(@RequestBody PagamentoVO pagamentoVO) {
        return pagamentoService.atualizar(pagamentoVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
