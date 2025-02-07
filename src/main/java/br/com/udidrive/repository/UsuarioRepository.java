package br.com.udidrive.repository;

import br.com.udidrive.model.Foto;
import br.com.udidrive.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
