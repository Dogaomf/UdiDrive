package br.com.udidrive.controller;

import br.com.udidrive.vo.UsuarioVO;
import br.com.udidrive.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UsuarioVO create(@RequestBody UsuarioVO usuarioVO) {
        return usuarioService.criarUsuario(usuarioVO);
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<UsuarioVO> findAll() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping(value = "/{email}",
                 produces = {MediaType.APPLICATION_JSON_VALUE})
    public UsuarioVO fyndByEmail(@PathVariable(value = "email") String email) {
        return usuarioService.buscarPorEmail(email);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public UsuarioVO update( @RequestBody UsuarioVO usuarioVO) {
        return usuarioService.atualizar(usuarioVO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) throws Exception {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
