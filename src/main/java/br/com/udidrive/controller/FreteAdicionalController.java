package br.com.udidrive.controller;

import br.com.udidrive.model.FreteAdicional;
import br.com.udidrive.service.FreteAdicionalService;
import br.com.udidrive.vo.FreteAdicionalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fretes")
public class FreteAdicionalController {
    @Autowired
    private FreteAdicionalService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<FreteAdicionalVO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public FreteAdicionalVO buscarPorId(@PathVariable(value = "id") Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public FreteAdicionalVO salvar(@RequestBody FreteAdicionalVO freteAdicionalVO) {
        return service.salvar(freteAdicionalVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public FreteAdicionalVO atualizar(@RequestBody FreteAdicionalVO freteAdicionalVO) {
        return service.atualizar(freteAdicionalVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
