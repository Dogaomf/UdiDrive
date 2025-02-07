package br.com.udidrive.vo;

import lombok.Data;

@Data
public class ClienteVO {
    private Long idCliente;
    private Long idUsuario;
    private String cpf;
    private String dataNascimento;
    private Double avaliacaoMedia;
}
