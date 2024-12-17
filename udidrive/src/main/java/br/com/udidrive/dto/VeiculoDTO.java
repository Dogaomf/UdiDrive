package br.com.udidrive.dto;

import lombok.Data;

@Data
public class VeiculoDTO {
    private Long idVeiculo;
    private Long idMotorista;
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private Integer ano;
    private Double capacidadeCarga;
}
