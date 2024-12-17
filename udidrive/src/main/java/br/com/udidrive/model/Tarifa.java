package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tarifas")
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tarifa")
    private Long idTarifa;

    @Column(name = "tipo_tarifa", nullable = false, length = 15)
    private String tipoTarifa;

    @Column(name = "custo_base", nullable = false, precision = 10, scale = 2)
    private Double custoBase;

    @Column(name = "custo_por_km", precision = 10, scale = 2)
    private Double custoPorKm;

    @Column(name = "custo_por_minuto", precision = 10, scale = 2)
    private Double custoPorMinuto;
}
