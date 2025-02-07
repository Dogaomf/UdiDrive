package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RastreamentoVO {
    private Long idRastreamento;
    private Long idPedido;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private LocalDateTime dataHora;
}