package br.com.udidrive.controller;

import br.com.udidrive.model.FreteAdicional;
import br.com.udidrive.service.FreteAdicionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/fretes")
public class FreteAdicionalController {
    @Autowired
    private FreteAdicionalService service;

    @GetMapping
    public ResponseEntity<List<FreteAdicional>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreteAdicional> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FreteAdicional> salvar(@RequestBody FreteAdicional frete) {
        return ResponseEntity.ok(service.salvar(frete));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreteAdicional> atualizar(@PathVariable Long id, @RequestBody FreteAdicional freteAtualizado) {
        return ResponseEntity.ok(service.atualizar(id, freteAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
