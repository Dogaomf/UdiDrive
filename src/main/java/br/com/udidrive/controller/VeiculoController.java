package br.com.udidrive.controller;

import br.com.udidrive.model.Veiculo;
import br.com.udidrive.service.VeiculoService;
import br.com.udidrive.vo.VeiculoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<VeiculoVO> listarTodos() {
        return veiculoService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public VeiculoVO buscarPorId(@PathVariable Long id) {
        return veiculoService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public VeiculoVO salvar(@RequestBody VeiculoVO veiculoVO) {
        return veiculoService.salvar(veiculoVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public VeiculoVO atualizar(@RequestBody VeiculoVO veiculoVO) {
        return veiculoService.atualizar( veiculoVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
