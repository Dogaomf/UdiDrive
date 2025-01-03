package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "veiculos")
@Getter
@Setter
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Long idVeiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_motorista", nullable = false)
    private Motorista motorista;

    @Column(nullable = false, length = 100)
    private String modelo;

    @Column(nullable = false, length = 100)
    private String marca;

    @Column(unique = true, nullable = false, length = 10)
    private String placa;

    @Column(length = 20)
    private String cor;

    private Integer ano;

    @Column(name = "capacidade_carga")
    private BigDecimal capacidadeCarga;
}
