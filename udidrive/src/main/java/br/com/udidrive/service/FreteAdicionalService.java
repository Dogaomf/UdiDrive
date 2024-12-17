package br.com.udidrive.service;

import br.com.udidrive.model.FreteAdicional;
import br.com.udidrive.repository.FreteAdicionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreteAdicionalService {
    @Autowired
    private FreteAdicionalRepository repository;

    public List<FreteAdicional> listarTodos() {
        return repository.findAll();
    }

    public Optional<FreteAdicional> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public FreteAdicional salvar(FreteAdicional frete) {
        return repository.save(frete);
    }

    public FreteAdicional atualizar(Long id, FreteAdicional freteAtualizado) {
        FreteAdicional frete = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Frete não encontrado"));
        frete.setValorAdicional(freteAtualizado.getValorAdicional());
        frete.setMotivo(freteAtualizado.getMotivo());
        return repository.save(frete);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
