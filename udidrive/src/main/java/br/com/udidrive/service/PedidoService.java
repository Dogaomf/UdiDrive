package br.com.udidrive.service;

import br.com.udidrive.model.Pedido;
import br.com.udidrive.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoAtualizado) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setMotorista(pedidoAtualizado.getMotorista());
        pedido.setStatus(pedidoAtualizado.getStatus());
        pedido.setTipoPedido(pedidoAtualizado.getTipoPedido());
        pedido.setDistanciaKm(pedidoAtualizado.getDistanciaKm());
        pedido.setDataFinalizacao(pedidoAtualizado.getDataFinalizacao());
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
