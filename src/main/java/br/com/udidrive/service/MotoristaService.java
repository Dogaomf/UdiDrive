package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Motorista;
import br.com.udidrive.repository.MotoristaRepository;
import br.com.udidrive.vo.MotoristaVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MotoristaService {
    private Logger logger = Logger.getLogger(MotoristaService.class.getName());

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<MotoristaVO> listarTodos() {
        logger.info("Finding all driver");

        var motorista =  Mapper.parseListObject(motoristaRepository.findAll(), MotoristaVO.class);
        //motorista.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return motorista;
    }

    public MotoristaVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  motoristaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, MotoristaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public MotoristaVO salvar(MotoristaVO motoristaVO) {
        if(motoristaVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(motoristaVO, Motorista.class);
        var vo = Mapper.parseObject(motoristaRepository.save(entity),MotoristaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public MotoristaVO atualizar(MotoristaVO motoristaVO) {
        if(motoristaVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = motoristaRepository.findById(motoristaVO.getIdMotorista()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setCnh(motoristaVO.getCnh());
        entity.setStatus(motoristaVO.getStatus());
        entity.setAvaliacaoMedia(motoristaVO.getAvaliacaoMedia());

        var vo = Mapper.parseObject(motoristaRepository.save(entity),MotoristaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one driver");
        var entity = motoristaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        motoristaRepository.delete(entity);
    }
}
