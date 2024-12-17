package br.com.udidrive.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RastreamentoDTO {
    private Long idRastreamento;
    private Long idPedido;
    private Double latitude;
    private Double longitude;
    private LocalDateTime dataHora;
}