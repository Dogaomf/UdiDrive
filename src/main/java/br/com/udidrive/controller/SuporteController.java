package br.com.udidrive.controller;

import br.com.udidrive.service.SuporteService;
import br.com.udidrive.vo.SuporteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suporte")
public class SuporteController {

    @Autowired
    private SuporteService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<SuporteVO> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public SuporteVO buscarPorId(@PathVariable(value = "id") Long id) {
        return service.buscarPorId(id);

    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public SuporteVO salvar(@RequestBody SuporteVO suporteVO) {
        return service.salvar(suporteVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public SuporteVO update(@RequestBody SuporteVO suporteVO) {
        return service.atualizar(suporteVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
