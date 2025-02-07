package br.com.udidrive.controller;

import br.com.udidrive.vo.EnderecoVO;
import br.com.udidrive.model.Endereco;
import br.com.udidrive.service.EnderecoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/endereco")
@RequiredArgsConstructor
public class EnderecoController {
    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody EnderecoVO enderecoDTO) {
        return ResponseEntity.ok(enderecoService.criarEndereco(enderecoDTO));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarEndereco() {
        return ResponseEntity.ok(enderecoService.listarEndereco());
    }
}
