package br.com.udidrive.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SuporteVO {
    private Long idTicket;
    private Long idUsuario;
    private String descricao;
    private String status;
    private LocalDateTime dataCriacao;
}