package br.com.udidrive.controller;

import br.com.udidrive.model.Suporte;
import br.com.udidrive.service.SuporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suporte")
public class SuporteController {

    @Autowired
    private SuporteService service;

    @GetMapping
    public ResponseEntity<List<Suporte>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Suporte> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Suporte> salvar(@RequestBody Suporte suporte) {
        return ResponseEntity.ok(service.salvar(suporte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
