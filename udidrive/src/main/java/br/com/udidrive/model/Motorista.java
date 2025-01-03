package br.com.udidrive.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "motoristas")
@Getter
@Setter
public class Motorista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_motorista")
    private Long idMotorista;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @Column(unique = true, nullable = false, length = 20)
    private String cnh;

    @Column(nullable = false, length = 15)
    private String status;

    @Column(name = "avaliacao_media")
    private BigDecimal avaliacaoMedia;
}
