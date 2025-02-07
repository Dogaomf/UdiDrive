package br.com.udidrive.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioVO {
    private Long idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String tipoUsuario;
}
