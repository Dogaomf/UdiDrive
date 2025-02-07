package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.vo.UsuarioVO;
import br.com.udidrive.model.Usuario;
import br.com.udidrive.repository.UsuarioRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

@Data
@Service
@RequiredArgsConstructor
public class UsuarioService {
    private Logger logger = Logger.getLogger(UsuarioService.class.getName());

    private final UsuarioRepository usuarioRepository;

    public UsuarioVO criarUsuario(UsuarioVO usuarioVO) {
        if(usuarioVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(usuarioVO, Usuario.class);
        var vo = Mapper.parseObject(usuarioRepository.save(entity),UsuarioVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public List<UsuarioVO> listarUsuarios() {
        logger.info("Finding all person");

        var users =  Mapper.parseListObject(usuarioRepository.findAll(), UsuarioVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return users;
    }

    public UsuarioVO buscarPorEmail(String email) {
        logger.info("Finding one person");
        var entity =  usuarioRepository.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, UsuarioVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public UsuarioVO atualizar(UsuarioVO usuarioVO)  {
        if(usuarioVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var entity = usuarioRepository.findById(usuarioVO.getIdUsuario()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        entity.setNome(usuarioVO.getNome());
        entity.setSenha(usuarioVO.getSenha());
        entity.setTelefone(usuarioVO.getTelefone());

        var vo = Mapper.parseObject(usuarioRepository.save(entity),UsuarioVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = usuarioRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        usuarioRepository.delete(entity);
    }

}
