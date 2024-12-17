package br.com.udidrive.dto;

import lombok.Data;

@Data
public class MotoristaDTO {
    private Long idMotorista;
    private Long idUsuario;
    private String cnh;
    private String status;
    private Double avaliacaoMedia;
}
