package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarteiraVO {
    private Long idCarteira;
    private Long idUsuario;
    private BigDecimal saldoAtual;
}
