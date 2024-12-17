package br.com.udidrive.service;

import br.com.udidrive.model.Rastreamento;
import br.com.udidrive.repository.RastreamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RastreamentoService {

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Rastreamento> listarTodos() {
        return rastreamentoRepository.findAll();
    }

    public Optional<Rastreamento> buscarPorId(Long id) {
        return rastreamentoRepository.findById(id);
    }

    public Rastreamento salvar(Rastreamento rastreamento) {
        return rastreamentoRepository.save(rastreamento);
    }

    public void deletar(Long id) {
        rastreamentoRepository.deleteById(id);
    }
}