package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Pedido;
import br.com.udidrive.repository.PedidoRepository;
import br.com.udidrive.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PedidoService {
    private Logger logger = Logger.getLogger(PedidoService.class.getName());

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoVO> listarTodos() {
        logger.info("Finding all person");

        var pedidos =  Mapper.parseListObject(pedidoRepository.findAll(), PedidoVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return pedidos;    }

    public PedidoVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  pedidoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, PedidoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public PedidoVO salvar(PedidoVO pedidoVO) {
        if(pedidoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(pedidoVO, Pedido.class);
        var vo = Mapper.parseObject(pedidoRepository.save(entity),PedidoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public PedidoVO atualizar(PedidoVO pedidoVO) {
        if(pedidoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");

        var pedido = pedidoRepository.findById(pedidoVO.getIdPedido())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setStatus(pedidoVO.getStatus());
        pedido.setTipoPedido(pedidoVO.getTipoPedido());
        pedido.setDistanciaKm(pedidoVO.getDistanciaKm());
        pedido.setDataFinalizacao(pedidoVO.getDataFinalizacao());
        var vo = Mapper.parseObject(pedidoRepository.save(pedido),PedidoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = pedidoRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        pedidoRepository.delete(entity);    }
}
