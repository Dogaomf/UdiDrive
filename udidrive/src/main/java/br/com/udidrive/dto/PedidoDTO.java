package br.com.udidrive.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoDTO {
    private Long idPedido;
    private Long idCliente;
    private Long idMotorista;
    private Double origemLatitude;
    private Double origemLongitude;
    private Double destinoLatitude;
    private Double destinoLongitude;
    private Double distanciaKm;
    private String status;
    private String tipoPedido;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataFinalizacao;
}
