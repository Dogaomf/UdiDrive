package br.com.udidrive.service;

import br.com.udidrive.model.Tarifa;
import br.com.udidrive.repository.TarifaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarifaService {
    @Autowired
    private TarifaRepository tarifaRepository;

    public List<Tarifa> listarTodos() {
        return tarifaRepository.findAll();
    }

    public Optional<Tarifa> buscarPorId(Long id) {
        return tarifaRepository.findById(id);
    }

    public Tarifa salvar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public Tarifa atualizar(Long id, Tarifa tarifaAtualizada) {
        Tarifa tarifa = tarifaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarifa não encontrada"));
        tarifa.setTipoTarifa(tarifaAtualizada.getTipoTarifa());
        tarifa.setCustoBase(tarifaAtualizada.getCustoBase());
        tarifa.setCustoPorKm(tarifaAtualizada.getCustoPorKm());
        tarifa.setCustoPorMinuto(tarifaAtualizada.getCustoPorMinuto());
        return tarifaRepository.save(tarifa);
    }

    public void deletar(Long id) {
        tarifaRepository.deleteById(id);
    }
}
