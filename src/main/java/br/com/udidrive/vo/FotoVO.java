package br.com.udidrive.vo;

import lombok.Data;

@Data
public class FotoVO {
    private Long idFoto;
    private Integer entidadeTipo; // ID do tipo de entidade (cliente, motorista, veículo)
    private Integer entidadeId;   // ID da entidade associada (cliente, motorista ou veículo)
    private byte[] foto;          // Foto em formato binário
    private String criadoEm;      // Data de criação, formatada para transferência
}