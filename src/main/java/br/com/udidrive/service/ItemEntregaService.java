package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.ItemEntrega;
import br.com.udidrive.repository.ItemEntregaRepository;
import br.com.udidrive.vo.ItemEntregaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ItemEntregaService {
    private Logger logger = Logger.getLogger(ItemEntregaService.class.getName());

    @Autowired
    private ItemEntregaRepository itemEntregaRepository;

    public List<ItemEntregaVO> listarTodos() {
        logger.info("Finding all person");

        var itemEntrega =  Mapper.parseListObject(itemEntregaRepository.findAll(), ItemEntregaVO.class);
        //itemEntrega.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return itemEntrega;    }

    public ItemEntregaVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  itemEntregaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, ItemEntregaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;    }

    public ItemEntregaVO salvar(ItemEntregaVO itemEntregaVO) {
        if(itemEntregaVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(itemEntregaVO, ItemEntrega.class);
        var vo = Mapper.parseObject(itemEntregaRepository.save(entity),ItemEntregaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public ItemEntregaVO atualizar(ItemEntregaVO itemEntregaVO) {
        if(itemEntregaVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = itemEntregaRepository.findById(itemEntregaVO.getIdItem()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setDescricao(itemEntregaVO.getDescricao());
        entity.setDimensoes(itemEntregaVO.getDimensoes());
        entity.setIdItem(itemEntregaVO.getIdItem());

        var vo = Mapper.parseObject(itemEntregaRepository.save(entity),ItemEntregaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = itemEntregaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        itemEntregaRepository.delete(entity);    }
}
