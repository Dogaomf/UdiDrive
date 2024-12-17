package br.com.udidrive.service;

import br.com.udidrive.model.Veiculo;
import br.com.udidrive.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {
    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Long id, Veiculo veiculoAtualizado) {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
        veiculo.setModelo(veiculoAtualizado.getModelo());
        veiculo.setMarca(veiculoAtualizado.getMarca());
        veiculo.setPlaca(veiculoAtualizado.getPlaca());
        veiculo.setCor(veiculoAtualizado.getCor());
        veiculo.setAno(veiculoAtualizado.getAno());
        veiculo.setCapacidadeCarga(veiculoAtualizado.getCapacidadeCarga());
        return veiculoRepository.save(veiculo);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}
