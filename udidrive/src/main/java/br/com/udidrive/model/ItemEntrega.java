package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "itens_entrega")
@Getter
@Setter
public class ItemEntrega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long idItem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(name = "peso_kg")
    private BigDecimal pesoKg;

    @Column(length = 50)
    private String dimensoes;
}
