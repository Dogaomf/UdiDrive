package br.com.udidrive.controller;

import br.com.udidrive.service.CarteiraService;
import br.com.udidrive.vo.CarteiraVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {
    @Autowired
    private CarteiraService service;

    /*@GetMapping
    public ResponseEntity<List<Carteira>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }*/

    @GetMapping(value = "/{idUsuario}",
                produces = {MediaType.APPLICATION_JSON_VALUE})
    public CarteiraVO buscarPorIdUsuario(@PathVariable(value = "id") Long id) {
        return service.findByUsuarioId(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CarteiraVO salvar(@RequestBody CarteiraVO carteiraVO) {
        return service.salvar(carteiraVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public CarteiraVO atualizar( @RequestBody CarteiraVO carteiraVO) {
        return service.atualizar(carteiraVO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
