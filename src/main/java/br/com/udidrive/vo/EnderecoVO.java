package br.com.udidrive.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EnderecoVO {
    private String idEndereco;
    private String logradouro;
    private String numero;
    private String complemento;
    private String Bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;
}
