package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motorista")
    private Motorista motorista;

    @Column(name = "origem_latitude", precision = 10, scale = 7, nullable = false)
    private Double origemLatitude;

    @Column(name = "origem_longitude", precision = 10, scale = 7, nullable = false)
    private Double origemLongitude;

    @Column(name = "destino_latitude", precision = 10, scale = 7, nullable = false)
    private Double destinoLatitude;

    @Column(name = "destino_longitude", precision = 10, scale = 7, nullable = false)
    private Double destinoLongitude;

    @Column(name = "distancia_km", precision = 10, scale = 2)
    private Double distanciaKm;

    @Column(nullable = false, length = 15)
    private String status;

    @Column(name = "tipo_pedido", nullable = false, length = 15)
    private String tipoPedido;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_finalizacao")
    private LocalDateTime dataFinalizacao;
}
