package br.com.udidrive.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarteiraDTO {
    private Long idCarteira;
    private Long idUsuario;
    private BigDecimal saldoAtual;
}
