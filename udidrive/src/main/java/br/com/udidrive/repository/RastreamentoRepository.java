package br.com.udidrive.repository;

import br.com.udidrive.model.Rastreamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RastreamentoRepository extends JpaRepository<Rastreamento, Long> {
}
