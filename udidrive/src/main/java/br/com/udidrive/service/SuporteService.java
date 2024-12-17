package br.com.udidrive.service;

import br.com.udidrive.model.Suporte;
import br.com.udidrive.repository.SuporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuporteService {

    @Autowired
    private SuporteRepository repository;

    public List<Suporte> listarTodos() {
        return repository.findAll();
    }

    public Optional<Suporte> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Suporte salvar(Suporte suporte) {
        return repository.save(suporte);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
