package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.FreteAdicional;
import br.com.udidrive.repository.FreteAdicionalRepository;
import br.com.udidrive.vo.FreteAdicionalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class FreteAdicionalService {
    private Logger logger = Logger.getLogger(FreteAdicionalService.class.getName());

    @Autowired
    private FreteAdicionalRepository repository;

    public List<FreteAdicionalVO> listarTodos() {
        logger.info("Finding all person");

        var fretes =  Mapper.parseListObject(repository.findAll(), FreteAdicionalVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return fretes;    }

    public FreteAdicionalVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  repository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, FreteAdicionalVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;    }

    public FreteAdicionalVO salvar(FreteAdicionalVO freteAdicionalVO) {
        if(freteAdicionalVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(freteAdicionalVO, FreteAdicional.class);
        var vo = Mapper.parseObject(repository.save(entity),FreteAdicionalVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public FreteAdicionalVO atualizar(FreteAdicionalVO freteAdicionalVO) {
        if(freteAdicionalVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = repository.findById(freteAdicionalVO.getIdFrete()).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setMotivo(freteAdicionalVO.getMotivo());
        entity.setValorAdicional(freteAdicionalVO.getValorAdicional());


        var vo = Mapper.parseObject(repository.save(entity),FreteAdicionalVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = repository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        repository.delete(entity);
    }
}
