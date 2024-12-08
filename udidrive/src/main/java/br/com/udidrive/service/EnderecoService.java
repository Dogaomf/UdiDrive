package br.com.udidrive.service;

import br.com.udidrive.dto.EnderecoDTO;
import br.com.udidrive.model.Endereco;
import br.com.udidrive.repository.EnderecoRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;

    public Endereco criarEndereco(EnderecoDTO enderecoDTO){
        Endereco endereco = Endereco.builder()
                .logradouro(enderecoDTO.getLogradouro())
                .numero(enderecoDTO.getNumero())
                .complemento(enderecoDTO.getComplemento())
                .bairro(enderecoDTO.getBairro())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .cep(enderecoDTO.getCep())
                .pais(enderecoDTO.getPais())
                .build();
        return enderecoRepository.save(endereco);
    }
    public List<Endereco> listarEndereco() {
        return enderecoRepository.findAll();
    }

}
