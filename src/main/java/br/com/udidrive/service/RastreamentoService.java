package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Rastreamento;
import br.com.udidrive.repository.RastreamentoRepository;
import br.com.udidrive.vo.RastreamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RastreamentoService {
    private Logger logger = Logger.getLogger(RastreamentoService.class.getName());

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<RastreamentoVO> listarTodos(){
        logger.info("Finding all person");

        var rastreamento =  Mapper.parseListObject(rastreamentoRepository.findAll(), RastreamentoVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return rastreamento;
    }

    public RastreamentoVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  rastreamentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, RastreamentoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;    }

    public RastreamentoVO salvar(RastreamentoVO rastreamentoVO) {
        if(rastreamentoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(rastreamentoVO, Rastreamento.class);
        var vo = Mapper.parseObject(rastreamentoRepository.save(entity),RastreamentoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public RastreamentoVO atualizar(RastreamentoVO rastreamentoVO)  {
        if(rastreamentoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = rastreamentoRepository.findById(rastreamentoVO.getIdRastreamento()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setDataHora(rastreamentoVO.getDataHora());
        entity.setLatitude(rastreamentoVO.getLatitude());
        entity.setLongitude(rastreamentoVO.getLongitude());

        var vo = Mapper.parseObject(rastreamentoRepository.save(entity),RastreamentoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = rastreamentoRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        rastreamentoRepository.delete(entity);
    }
}