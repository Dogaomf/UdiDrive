package br.com.udidrive.service;

import br.com.udidrive.dto.UsuarioDTO;
import br.com.udidrive.model.Usuario;
import br.com.udidrive.repository.UsuarioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = Usuario.builder()
                .nome(usuarioDTO.getNome())
                .email(usuarioDTO.getEmail())
                .senha(usuarioDTO.getSenha()) // Certifique-se de usar hash na senha antes de salvar
                .telefone(usuarioDTO.getTelefone())
                .tipoUsuario(usuarioDTO.getTipoUsuario())
                .dataCriacao(LocalDateTime.now())
                .build();
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}
