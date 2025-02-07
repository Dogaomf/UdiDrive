package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Tarifa;
import br.com.udidrive.repository.TarifaRepository;
import br.com.udidrive.vo.TarifaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class TarifaService {
    private Logger logger = Logger.getLogger(SuporteService.class.getName());

    @Autowired
    private TarifaRepository tarifaRepository;

    public List<TarifaVO> listarTodos() {
        logger.info("Finding all person");

        var tarifa =  Mapper.parseListObject(tarifaRepository.findAll(), TarifaVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return tarifa;
    }

    public TarifaVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  tarifaRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, TarifaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public TarifaVO salvar(TarifaVO tarifaVO) {
        if(tarifaVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(tarifaVO, Tarifa.class);
        var vo = Mapper.parseObject(tarifaRepository.save(entity),TarifaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;    }

    public TarifaVO atualizar(TarifaVO tarifaVO) {
        if(tarifaVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");

        var tarifa = tarifaRepository.findById(tarifaVO.getIdTarifa())
                .orElseThrow(() -> new RuntimeException("Tarifa não encontrada"));
        tarifa.setTipoTarifa(tarifaVO.getTipoTarifa());
        tarifa.setCustoBase(tarifaVO.getCustoBase());
        tarifa.setCustoPorKm(tarifaVO.getCustoPorKm());
        tarifa.setCustoPorMinuto(tarifaVO.getCustoPorMinuto());
        var vo = Mapper.parseObject(tarifaRepository.save(tarifa),TarifaVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = tarifaRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        tarifaRepository.delete(entity);    }
}
