package br.com.udidrive.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class VeiculoVO {
    private Long idVeiculo;
    private Long idMotorista;
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private Integer ano;
    private BigDecimal capacidadeCarga;
}
