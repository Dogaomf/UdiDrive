package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entidade_tipos")
@Data
public class EntidadeTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Long idTipo;

    @Column(name = "descricao", nullable = false, length = 50)
    private String descricao;
}