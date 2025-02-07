package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Pagamento;
import br.com.udidrive.repository.PagamentoRepository;
import br.com.udidrive.vo.PagamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PagamentoService {
    private Logger logger = Logger.getLogger(PagamentoService.class.getName());

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public List<PagamentoVO> listarTodos() {
        logger.info("Finding all person");

        var pagamentos =  Mapper.parseListObject(pagamentoRepository.findAll(), PagamentoVO.class);
        //persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getidPerson())).withSelfRel()));
        return pagamentos;
    }

    public PagamentoVO buscarPorId(Long id) {
        logger.info("Finding one person");
        var entity =  pagamentoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        var vo =  Mapper.parseObject(entity, PagamentoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(idPerson)).withSelfRel());
        return vo;
    }

    public PagamentoVO salvar(PagamentoVO pagamentoVO) {
        if(pagamentoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("create one person");
        var entity = Mapper.parseObject(pagamentoVO, Pagamento.class);
        var vo = Mapper.parseObject(pagamentoRepository.save(entity),PagamentoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public PagamentoVO atualizar(PagamentoVO pagamentoVO) {
        if(pagamentoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("update one person");
        var pagamento = pagamentoRepository.findById(pagamentoVO.getIdPagamento()).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));

        pagamento.setValorTotal(pagamentoVO.getValorTotal());
        pagamento.setMetodoPagamento(pagamentoVO.getMetodoPagamento());
        pagamento.setStatus(pagamentoVO.getStatus());
        pagamento.setDataPagamento(pagamentoVO.getDataPagamento());

        var vo = Mapper.parseObject(pagamentoRepository.save(pagamento),PagamentoVO.class);
        //vo.add(linkTo(methodOn(PersonController.class).findById(vo.getidPerson())).withSelfRel());
        return vo;
    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = pagamentoRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        pagamentoRepository.delete(entity);
    }
}
