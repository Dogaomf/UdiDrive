package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TarifaVO {
    private Long idTarifa;
    private String tipoTarifa;
    private BigDecimal custoBase;
    private BigDecimal custoPorKm;
    private BigDecimal custoPorMinuto;
}
