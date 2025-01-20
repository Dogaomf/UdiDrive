package br.com.udidrive.repository;

import br.com.udidrive.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotoRepository extends JpaRepository<Foto, Long> {

    // Consultar fotos por tipo de entidade e ID da entidade
    List<Foto> findByEntidadeTipoIdTipoAndEntidadeId(Long idTipo, Long entidadeId);
}