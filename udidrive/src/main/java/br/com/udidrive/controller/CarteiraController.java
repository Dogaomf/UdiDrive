package br.com.udidrive.controller;

import br.com.udidrive.model.Carteira;
import br.com.udidrive.service.CarteiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {
    @Autowired
    private CarteiraService service;

    @GetMapping
    public ResponseEntity<List<Carteira>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carteira> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carteira> salvar(@RequestBody Carteira carteira) {
        return ResponseEntity.ok(service.salvar(carteira));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carteira> atualizar(@PathVariable Long id, @RequestBody Carteira carteiraAtualizada) {
        return ResponseEntity.ok(service.atualizar(id, carteiraAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
