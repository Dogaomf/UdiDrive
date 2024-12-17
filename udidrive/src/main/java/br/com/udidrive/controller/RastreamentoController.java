package br.com.udidrive.controller;

import br.com.udidrive.model.Rastreamento;
import br.com.udidrive.service.RastreamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamento")
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @GetMapping
    public ResponseEntity<List<Rastreamento>> listarTodos() {
        return ResponseEntity.ok(rastreamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rastreamento> buscarPorId(@PathVariable Long id) {
        return rastreamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Rastreamento> salvar(@RequestBody Rastreamento rastreamento) {
        return ResponseEntity.ok(rastreamentoService.salvar(rastreamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        rastreamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}