package br.com.udidrive.controller;

import br.com.udidrive.model.Motorista;
import br.com.udidrive.service.MotoristaService;
import br.com.udidrive.vo.MotoristaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<MotoristaVO> listarTodos() {
        return motoristaService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MotoristaVO buscarPorId(@PathVariable(value = "id") Long id) {
        return motoristaService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MotoristaVO salvar(@RequestBody MotoristaVO motoristavo) {
        return motoristaService.salvar(motoristavo);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public MotoristaVO atualizar(@RequestBody MotoristaVO motoristaVO) {
        return motoristaService.atualizar(motoristaVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        motoristaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
