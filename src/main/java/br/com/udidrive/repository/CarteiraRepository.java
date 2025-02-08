package br.com.udidrive.repository;

import br.com.udidrive.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
    Optional<Carteira> findByUsuarioIdUsuario(Long idUsuario);  // Ajuste para refletir o nome correto do campo
}
