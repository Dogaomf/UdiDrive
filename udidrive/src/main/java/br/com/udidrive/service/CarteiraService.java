package br.com.udidrive.service;

import br.com.udidrive.model.Carteira;
import br.com.udidrive.repository.CarteiraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarteiraService {
    @Autowired
    private CarteiraRepository repository;

    public List<Carteira> listarTodas() {
        return repository.findAll();
    }

    public Optional<Carteira> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Carteira salvar(Carteira carteira) {
        return repository.save(carteira);
    }

    public Carteira atualizar(Long id, Carteira carteiraAtualizada) {
        Carteira carteira = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        carteira.setSaldoAtual(carteiraAtualizada.getSaldoAtual());
        return repository.save(carteira);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
