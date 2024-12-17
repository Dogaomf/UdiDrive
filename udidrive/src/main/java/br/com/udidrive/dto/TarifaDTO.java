package br.com.udidrive.dto;

import lombok.Data;

@Data
public class TarifaDTO {
    private Long idTarifa;
    private String tipoTarifa;
    private Double custoBase;
    private Double custoPorKm;
    private Double custoPorMinuto;
}
