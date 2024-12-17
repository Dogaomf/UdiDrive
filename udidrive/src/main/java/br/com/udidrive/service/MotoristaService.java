package br.com.udidrive.service;

import br.com.udidrive.model.Motorista;
import br.com.udidrive.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoristaService {
    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> listarTodos() {
        return motoristaRepository.findAll();
    }

    public Optional<Motorista> buscarPorId(Long id) {
        return motoristaRepository.findById(id);
    }

    public Motorista salvar(Motorista motorista) {
        return motoristaRepository.save(motorista);
    }

    public Motorista atualizar(Long id, Motorista motoristaAtualizado) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));
        motorista.setCnh(motoristaAtualizado.getCnh());
        motorista.setStatus(motoristaAtualizado.getStatus());
        motorista.setAvaliacaoMedia(motoristaAtualizado.getAvaliacaoMedia());
        return motoristaRepository.save(motorista);
    }

    public void deletar(Long id) {
        motoristaRepository.deleteById(id);
    }
}
