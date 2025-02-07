package br.com.udidrive.repository;

import br.com.udidrive.model.Avaliacao;
import br.com.udidrive.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {

    // Consultar fotos por tipo de entidade e ID da entidade
    Optional<Avaliacao> findByEntidadeTipoIdTipoAndEntidadeId(Long idTipo, Long entidadeId);
}