package br.com.udidrive.repository;

import br.com.udidrive.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

    // Consultar fotos por tipo de entidade e ID da entidade
    Optional<Foto> findByEntidadeTipoIdTipoAndEntidadeId(Long idTipo, Long entidadeId);
}