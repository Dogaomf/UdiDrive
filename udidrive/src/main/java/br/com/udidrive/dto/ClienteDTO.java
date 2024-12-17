package br.com.udidrive.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long idCliente;
    private Long idUsuario;
    private String cpf;
    private String dataNascimento;
    private Double avaliacaoMedia;
}
