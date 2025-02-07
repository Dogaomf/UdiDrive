package br.com.udidrive.vo;

import lombok.Data;

@Data
public class FreteAdicionalVO {
    private Long idFrete;
    private Long idPedido;
    private Double valorAdicional;
    private String motivo;
}
