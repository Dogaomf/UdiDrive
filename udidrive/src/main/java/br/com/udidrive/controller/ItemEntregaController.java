package br.com.udidrive.controller;

import br.com.udidrive.model.ItemEntrega;
import br.com.udidrive.service.ItemEntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-entrega")
public class ItemEntregaController {
    @Autowired
    private ItemEntregaService itemEntregaService;

    @GetMapping
    public ResponseEntity<List<ItemEntrega>> listarTodos() {
        return ResponseEntity.ok(itemEntregaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemEntrega> buscarPorId(@PathVariable Long id) {
        return itemEntregaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemEntrega> salvar(@RequestBody ItemEntrega itemEntrega) {
        return ResponseEntity.ok(itemEntregaService.salvar(itemEntrega));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemEntrega> atualizar(@PathVariable Long id, @RequestBody ItemEntrega itemEntregaAtualizado) {
        return ResponseEntity.ok(itemEntregaService.atualizar(id, itemEntregaAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        itemEntregaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
