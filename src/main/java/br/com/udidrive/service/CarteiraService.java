package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Carteira;
import br.com.udidrive.repository.CarteiraRepository;
import br.com.udidrive.vo.CarteiraVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CarteiraService {
    private Logger logger = Logger.getLogger(CarteiraService.class.getName());

    @Autowired
    private CarteiraRepository repository;

    /*public List<Carteira> listarTodas() {
        return repository.findAll();
    }*/

    public CarteiraVO findByUsuarioId(Long id) {
        logger.info("Buscar a carteira de um usuario");
        var entity = repository.findByUsuarioId(id).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, CarteiraVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public CarteiraVO salvar(CarteiraVO carteiraVO) {
        if(carteiraVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("Criando a carteira de um usuario");
        var entity = Mapper.parseObject(carteiraVO, Carteira.class);
        var vo = Mapper.parseObject(repository.save(entity), CarteiraVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public CarteiraVO atualizar(CarteiraVO carteiraVO) {
        if(carteiraVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("Atualizar carteira de um usuario");
        var entity = repository.findByUsuarioId(carteiraVO.getIdUsuario()).orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID!"));

        entity.setSaldoAtual(carteiraVO.getSaldoAtual());

        var vo = Mapper.parseObject(repository.save(entity),CarteiraVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
