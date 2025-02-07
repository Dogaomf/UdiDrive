package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tarifas")
@Getter
@Setter
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifa")
    private Long idTarifa;

    @Column(name = "tipo_tarifa", nullable = false, length = 15)
    private String tipoTarifa;

    @Column(name = "custo_base", nullable = false)
    private BigDecimal custoBase;

    @Column(name = "custo_por_km")
    private BigDecimal custoPorKm;

    @Column(name = "custo_por_minuto")
    private BigDecimal custoPorMinuto;
}
