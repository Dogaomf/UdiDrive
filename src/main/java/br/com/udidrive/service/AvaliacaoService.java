package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Avaliacao;
import br.com.udidrive.repository.AvaliacaoRepository;
import br.com.udidrive.vo.AvaliacaoVO;
import br.com.udidrive.vo.FotoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AvaliacaoService {

    private Logger logger = Logger.getLogger(AvaliacaoService.class.getName());

    @Autowired
    private AvaliacaoRepository repository;

    public AvaliacaoVO buscarEntidadeId(Long entidadeTipo, Long entidadeId) {
        logger.info("Buscar avaliação por tipo de entidade e pelo id da entidade solicitada");

        var entity = repository.findByEntidadeTipoAndEntidadeId(entidadeTipo, entidadeId).orElse(null);
        // var entity =  repository.findByEntidadeTipoIdTipoAndEntidadeId(entidadeTipo, entidadeId).orElseThrow(() -> new ResourceNotFoundException("Não encontrado para o ID!"));

        //var avaliacao = Mapper.parseObject(repository.findByEntidadeTipoIdTipoAndEntidadeId(entidadeTipo,entidadeId), AvaliacaoVO.class);

        if (entity == null){
            logger.warning("Nenhuma avaliação encontrada para o tipo de entidade "
                    + entidadeTipo + " e ID " + entidadeId);

            // Retorna uma avaliação zerada
            AvaliacaoVO avaliacaoZerada = new AvaliacaoVO();
            avaliacaoZerada.setEntidadeTipo(entidadeTipo);
            avaliacaoZerada.setEntidadeId(entidadeId);
            avaliacaoZerada.setNota(0.0); // Por exemplo, define a nota como 0
            avaliacaoZerada.setComentario("Sem avaliação disponível");
            return avaliacaoZerada;
        }
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return Mapper.parseObject(entity, AvaliacaoVO.class);
    }

    public AvaliacaoVO salvar(AvaliacaoVO avaliacaoVO) {
        if(avaliacaoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("Salvando uma avaliação");
        var entity = Mapper.parseObject(avaliacaoVO, Avaliacao.class);
        var vo = Mapper.parseObject(repository.save(entity),AvaliacaoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}