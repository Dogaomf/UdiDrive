package br.com.udidrive.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PagamentoDTO {
    private Long idPagamento;
    private Long idPedido;
    private Double valorTotal;
    private String metodoPagamento;
    private String status;
    private LocalDateTime dataPagamento;
}
