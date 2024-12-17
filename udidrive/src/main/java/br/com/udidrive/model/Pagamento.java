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
@Table(name = "pagamentos")
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pagamento")
    private Long idPagamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @Column(name = "valor_total", nullable = false, precision = 10, scale = 2)
    private Double valorTotal;

    @Column(name = "metodo_pagamento", nullable = false, length = 20)
    private String metodoPagamento;

    @Column(nullable = false, length = 15)
    private String status;

    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;
}
