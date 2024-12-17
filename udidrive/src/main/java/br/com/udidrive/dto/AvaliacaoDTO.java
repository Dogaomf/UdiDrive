package br.com.udidrive.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AvaliacaoDTO {
    private Long idAvaliacao;
    private Long idPedido;
    private Integer nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;
}