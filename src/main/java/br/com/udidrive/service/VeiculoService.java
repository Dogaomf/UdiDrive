package br.com.udidrive.service;

import br.com.udidrive.exception.ResourceNotFoundException;
import br.com.udidrive.exception.ResourceObjectIsNullException;
import br.com.udidrive.mapper.Mapper;
import br.com.udidrive.model.Veiculo;
import br.com.udidrive.repository.VeiculoRepository;
import br.com.udidrive.vo.VeiculoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class VeiculoService {
    private Logger logger = Logger.getLogger(VeiculoService.class.getName());

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoVO> listarTodos() {
        logger.info("Buscar todos veiculos cadastrados");
        var veiculos = Mapper.parseListObject(veiculoRepository.findAll(), VeiculoVO.class);
        return veiculos;
        }

    public VeiculoVO buscarPorId(Long id) {
        logger.info("Buscar um veículo");
        var veiculo = veiculoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Nenhum veículo encontrado para esse ID!"));
        var vo = Mapper.parseObject(veiculo, VeiculoVO.class);
        return vo;
    }

    public VeiculoVO salvar(VeiculoVO veiculoVO) {
        if(veiculoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("Cadastrar um veículo");
        var entity = Mapper.parseObject(veiculoVO, Veiculo.class);
        var vo = Mapper.parseObject(veiculoRepository.save(entity),VeiculoVO.class);
        return vo;
    }

    public VeiculoVO atualizar(VeiculoVO veiculoVO) {
        if(veiculoVO == null){
            throw new ResourceObjectIsNullException();
        }
        logger.info("Atualizar o cadastro de um veículo");

        var veiculo = veiculoRepository.findById(veiculoVO.getIdVeiculo())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));

        veiculo.setModelo(veiculoVO.getModelo());
        veiculo.setMarca(veiculoVO.getMarca());
        veiculo.setPlaca(veiculoVO.getPlaca());
        veiculo.setCor(veiculoVO.getCor());
        veiculo.setAno(veiculoVO.getAno());
        veiculo.setCapacidadeCarga(veiculoVO.getCapacidadeCarga());

        var vo = Mapper.parseObject(veiculoRepository.save(veiculo),VeiculoVO.class);
        return vo;

    }

    public void deletar(Long id) {
        logger.info("delete one person");
        var entity = veiculoRepository.findById(id).
                orElseThrow(()->new ResourceNotFoundException("No Records found for this ID!"));
        veiculoRepository.delete(entity);
    }
}
