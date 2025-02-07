package br.com.udidrive.vo;

import lombok.Data;

@Data
public class ItemEntregaVO {
    private Long idItem;
    private Long idPedido;
    private String descricao;
    private Double pesoKg;
    private String dimensoes;
}
