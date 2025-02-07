package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Cliente;
import br.com.udidrive.repository.ClienteRepository;
import br.com.udidrive.vo.ClienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteService {
    private Logger logger = Logger.getLogger(ClienteService.class.getName());

    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteVO> listarTodos() {
        logger.info("Finding all person");

        var persons =  Mapper.parseListObject(clienteRepository.findAll(), ClienteVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return persons;
    }

    public ClienteVO buscarPorId(Long id) {
        logger.info("Buscar um cliente");

        var entity =  clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Nenhum registro encontrado para esse ID!"));
        var vo =  Mapper.parseObject(entity, ClienteVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public ClienteVO salvar(ClienteVO clienteVO) {
        if(clienteVO == null){
            throw new ResourceObjectIsNullException();
        }

        logger.info("Criar um cliente");

        var entity = Mapper.parseObject(clienteVO, Cliente.class);
        var vo = Mapper.parseObject(clienteRepository.save(entity),ClienteVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public ClienteVO atualizar(ClienteVO clienteVO) {
        if(clienteVO == null){
            throw new ResourceObjectIsNullException();
        }

        logger.info("Atualizar um cliente");

        Cliente cliente = clienteRepository.findById(clienteVO.getIdCliente()).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        cliente.setCpf(clienteVO.getCpf());
        cliente.setDataNascimento(LocalDate.parse(clienteVO.getDataNascimento()));
        cliente.setAvaliacaoMedia(clienteVO.getAvaliacaoMedia());

        var vo = Mapper.parseObject(clienteRepository.save(cliente),ClienteVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        var entity = clienteRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        clienteRepository.delete(entity);
    }
}
