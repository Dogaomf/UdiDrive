package br.com.udidrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntidadeTipo extends JpaRepository<EntidadeTipo, Integer> {
}
