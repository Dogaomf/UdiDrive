package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "fotos")
@Data
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoto;

    @ManyToOne
    @JoinColumn(name = "entidade_tipo", nullable = false)
    private EntidadeTipo entidadeTipo;

    @Column(nullable = false)
    private Integer entidadeId;

    @Lob
    @Column(nullable = false)
    private byte[] foto;

    @Column(nullable = false, updatable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();
}