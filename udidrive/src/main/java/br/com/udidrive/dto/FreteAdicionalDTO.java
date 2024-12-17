package br.com.udidrive.dto;

import lombok.Data;

@Data
public class FreteAdicionalDTO {
    private Long idFrete;
    private Long idPedido;
    private Double valorAdicional;
    private String motivo;
}
