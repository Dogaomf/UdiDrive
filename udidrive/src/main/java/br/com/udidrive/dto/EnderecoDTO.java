package br.com.udidrive.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EnderecoDTO {
    private String logradouro;
    private String numero;
    private String complemento;
    private String Bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
}
