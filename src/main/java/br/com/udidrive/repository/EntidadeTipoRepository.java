package br.com.udidrive.repository;

import br.com.udidrive.model.EntidadeTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeTipoRepository extends JpaRepository<EntidadeTipo, Long> {
}
