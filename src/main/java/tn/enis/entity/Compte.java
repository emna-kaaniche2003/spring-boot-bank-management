package tn.enis.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "t_compte")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rib")
    private Integer rib;

    @Column(name = "solde", nullable = false)
    private BigDecimal solde;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_cin", nullable = false)
    private Client client;
}