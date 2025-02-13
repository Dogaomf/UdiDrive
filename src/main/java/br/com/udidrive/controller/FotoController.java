package br.com.udidrive.controller;

import br.com.udidrive.vo.FotoVO;
import br.com.udidrive.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    public FotoVO salvarFoto(@RequestBody FotoVO fotoVO){

        return fotoService.salvar(fotoVO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public FotoVO update( @RequestBody FotoVO fotoVO) {
        return fotoService.atualizarFoto(fotoVO);
    }

    @GetMapping(value = "/{entidadeTipo}/{entidadeId}",
                    produces = (MediaType.APPLICATION_JSON_VALUE))
    public FotoVO buscarPorEntidade(@PathVariable(value = "entidadeTipo") Long entidadeTipo, @PathVariable(value = "entidadeId") Long entidadeId) {
        return fotoService.buscarPorEntidade(entidadeTipo, entidadeId);
    }

    @DeleteMapping("/{idFoto}")
    public ResponseEntity<?> excluirFoto(@PathVariable(value = "idFoto") Long idFoto) {
        fotoService.excluirPorId(idFoto);
        return ResponseEntity.noContent().build();
    }
}