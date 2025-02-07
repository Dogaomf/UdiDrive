package br.com.udidrive.controller;

import br.com.udidrive.service.ItemEntregaService;
import br.com.udidrive.vo.ItemEntregaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-entrega")
public class ItemEntregaController {
    @Autowired
    private ItemEntregaService itemEntregaService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<ItemEntregaVO> listarTodos() {
        return itemEntregaService.listarTodos();
    }

    @GetMapping(value="/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ItemEntregaVO buscarPorId(@PathVariable(value = "id") Long id) {
        return itemEntregaService.buscarPorId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ItemEntregaVO salvar(@RequestBody ItemEntregaVO itemEntregaVO) {
        return itemEntregaService.salvar(itemEntregaVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ItemEntregaVO atualizar(@PathVariable Long id, @RequestBody ItemEntregaVO itemEntregaVO) {
        return itemEntregaService.atualizar(itemEntregaVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable(value = "id") Long id) {
        itemEntregaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
