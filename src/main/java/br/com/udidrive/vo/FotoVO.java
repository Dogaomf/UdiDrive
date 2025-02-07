package br.com.udidrive.vo;

import lombok.Data;

@Data
public class FotoVO {
    private Long idFoto;
    private Long entidadeTipo; // ID do tipo de entidade (cliente, motorista, veículo)
    private Long entidadeId;   // ID da entidade associada (cliente, motorista ou veículo)
    private byte[] foto;          // Foto em formato binário
    private String criadoEm;      // Data de criação, formatada para transferência
}