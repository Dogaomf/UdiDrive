package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pedidos")
@Getter
@Setter
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

    @Column(name = "origem_latitude", nullable = false)
    private BigDecimal origemLatitude;

    @Column(name = "origem_longitude", nullable = false)
    private BigDecimal origemLongitude;

    @Column(name = "destino_latitude", nullable = false)
    private BigDecimal destinoLatitude;

    @Column(name = "destino_longitude", nullable = false)
    private BigDecimal destinoLongitude;

    @Column(name = "distancia_km")
    private BigDecimal distanciaKm;

    @Column(nullable = false, length = 15)
    private String status;

    @Column(name = "tipo_pedido", nullable = false, length = 15)
    private String tipoPedido;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_finalizacao")
    private LocalDateTime dataFinalizacao;
}
