package br.com.udidrive.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AvaliacaoVO {
    private Long idAvaliacao;
    private Long idPedido;
    private double nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;
    private Long entidadeTipo; // ID do tipo de entidade (1 = cliente, 2 = motorista, 3 = veículo)
    private Long entidadeId;   // ID da entidade associada (cliente, motorista ou veículo)
}