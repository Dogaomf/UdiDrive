package br.com.udidrive.controller;

import br.com.udidrive.service.AvaliacaoService;
import br.com.udidrive.vo.AvaliacaoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public AvaliacaoVO salvar(@RequestBody AvaliacaoVO avaliacaoVO) {
        return service.salvar(avaliacaoVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}