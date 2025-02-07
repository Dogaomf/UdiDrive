package br.com.udidrive.controller;

import br.com.udidrive.service.TarifaService;
import br.com.udidrive.vo.TarifaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarifas")
public class TarifaController {
    @Autowired
    private TarifaService tarifaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<TarifaVO> listarTodos() {
        return tarifaService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TarifaVO buscarPorId(@PathVariable Long id) {
        return tarifaService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TarifaVO salvar(@RequestBody TarifaVO tarifaVO) {
        return tarifaService.salvar(tarifaVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public TarifaVO atualizar(@RequestBody TarifaVO tarifaVO) {
        return tarifaService.atualizar(tarifaVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        tarifaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
