package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.vo.FotoVO;
import br.com.udidrive.model.Foto;
import br.com.udidrive.repository.FotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class FotoService {

    private Logger logger = Logger.getLogger(FotoService.class.getName());

    @Autowired
    private FotoRepository fotoRepository;

    public FotoVO salvar(FotoVO fotoVO) {
        if(fotoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("Criar uma postagem com foto");
        var entity = Mapper.parseObject(fotoVO, Foto.class);
        var vo = Mapper.parseObject(fotoRepository.save(entity),FotoVO.class);
        //vo.add(linkTo(methodOn(FotoController.class).findById(vo.getIdFoto())).withSelfRel()); link hateoas
        return vo;
    }

    public FotoVO atualizarFoto(FotoVO fotoVO) {
        if(fotoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = fotoRepository.findByEntidadeTipoIdTipoAndEntidadeId(fotoVO.getEntidadeTipo(), fotoVO.getEntidadeId()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setFoto(fotoVO.getFoto());

        var vo = Mapper.parseObject(fotoRepository.save(entity),FotoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public FotoVO buscarPorEntidade(Long idTipo, Long entidadeId) {
        logger.info("Buscar por id e entidade a foto desejada");
        var entity =  fotoRepository.findByEntidadeTipoIdTipoAndEntidadeId(idTipo, entidadeId).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo = Mapper.parseObject(entity, FotoVO.class);
        //fotos.stream().forEach(p -> p.add(linkTo(methodOn(FotoController.class).findById(p.getIdFoto())).withSelfRel()));
        return vo;
    }

    public void excluirPorId(Long idFoto) {
        logger.info("delete uma foto");
        var entity = fotoRepository.findById(idFoto).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        fotoRepository.delete(entity);
    }

}
