package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MotoristaVO {
    private Long idMotorista;
    private Long idUsuario;
    private String cnh;
    private String status;
    private BigDecimal avaliacaoMedia;
}
