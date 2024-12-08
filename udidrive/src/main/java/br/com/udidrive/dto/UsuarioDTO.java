package br.com.udidrive.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String tipoUsuario;
}
