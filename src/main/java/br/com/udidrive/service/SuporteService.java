package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Suporte;
import br.com.udidrive.repository.SuporteRepository;
import br.com.udidrive.vo.SuporteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SuporteService {
    private Logger logger = Logger.getLogger(SuporteService.class.getName());

    @Autowired
    private SuporteRepository suporteRepository;

    public List<SuporteVO> listarTodos() {
        logger.info("Finding all person");

        var suporte =  Mapper.parseListObject(suporteRepository.findAll(), SuporteVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return suporte;
    }

    public SuporteVO buscarPorId(Long id) {
        logger.info("Finding one person");

        var entity =  suporteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, SuporteVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public SuporteVO salvar(SuporteVO suporteVO) {
        if(suporteVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(suporteVO, Suporte.class);
        var vo = Mapper.parseObject(suporteRepository.save(entity),SuporteVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public SuporteVO atualizar(SuporteVO suporteVO)  {
        if(suporteVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = suporteRepository.findById(suporteVO.getIdTicket()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setStatus(suporteVO.getStatus());
        entity.setDataCriacao(suporteVO.getDataCriacao());
        entity.setDescricao(suporteVO.getDescricao());

        var vo = Mapper.parseObject(suporteRepository.save(entity),SuporteVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long idPerson) {
        logger.info("delete one person");
        var entity = suporteRepository.findById(idPerson).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        suporteRepository.delete(entity);
    }
}
