package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagamentoVO {
    private Long idPagamento;
    private Long idPedido;
    private BigDecimal valorTotal;
    private String metodoPagamento;
    private String status;
    private LocalDateTime dataPagamento;
}
