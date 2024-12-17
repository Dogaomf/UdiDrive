package br.com.udidrive.service;

import br.com.udidrive.model.ItemEntrega;
import br.com.udidrive.repository.ItemEntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemEntregaService {
    @Autowired
    private ItemEntregaRepository itemEntregaRepository;

    public List<ItemEntrega> listarTodos() {
        return itemEntregaRepository.findAll();
    }

    public Optional<ItemEntrega> buscarPorId(Long id) {
        return itemEntregaRepository.findById(id);
    }

    public ItemEntrega salvar(ItemEntrega itemEntrega) {
        return itemEntregaRepository.save(itemEntrega);
    }

    public ItemEntrega atualizar(Long id, ItemEntrega itemEntregaAtualizado) {
        ItemEntrega itemEntrega = itemEntregaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item de entrega não encontrado"));
        itemEntrega.setDescricao(itemEntregaAtualizado.getDescricao());
        itemEntrega.setPesoKg(itemEntregaAtualizado.getPesoKg());
        itemEntrega.setDimensoes(itemEntregaAtualizado.getDimensoes());
        return itemEntregaRepository.save(itemEntrega);
    }

    public void deletar(Long id) {
        itemEntregaRepository.deleteById(id);
    }
}
