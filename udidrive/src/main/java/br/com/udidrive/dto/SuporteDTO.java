package br.com.udidrive.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SuporteDTO {
    private Long idTicket;
    private Long idUsuario;
    private String descricao;
    private String status;
    private LocalDateTime dataCriacao;
}