package br.com.udidrive.dto;

import lombok.Data;

@Data
public class ItemEntregaDTO {
    private Long idItem;
    private Long idPedido;
    private String descricao;
    private Double pesoKg;
    private String dimensoes;
}
