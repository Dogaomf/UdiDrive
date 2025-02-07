package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PedidoVO {
    private Long idPedido;
    private Long idCliente;
    private Long idMotorista;
    private Double origemLatitude;
    private Double origemLongitude;
    private Double destinoLatitude;
    private Double destinoLongitude;
    private BigDecimal distanciaKm;
    private String status;
    private String tipoPedido;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataFinalizacao;
}
