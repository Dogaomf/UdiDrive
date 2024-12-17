package br.com.udidrive.controller;

import br.com.udidrive.model.Tarifa;
import br.com.udidrive.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tarifas")
public class TarifaController {
    @Autowired
    private TarifaService tarifaService;

    @GetMapping
    public ResponseEntity<List<Tarifa>> listarTodos() {
        return ResponseEntity.ok(tarifaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarifa> buscarPorId(@PathVariable Long id) {
        return tarifaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Tarifa> salvar(@RequestBody Tarifa tarifa) {
        return ResponseEntity.ok(tarifaService.salvar(tarifa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarifa> atualizar(@PathVariable Long id, @RequestBody Tarifa tarifaAtualizada) {
        return ResponseEntity.ok(tarifaService.atualizar(id, tarifaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        tarifaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
