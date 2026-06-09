package tn.enis.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "t_client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {



    @Id
    @Column(name = "cin", length = 20, nullable = false, unique = true)
    private String cin;

    @Column(name = "nom", length = 50, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 50, nullable = false)
    private String prenom;


    @ToString.Exclude
    // Propager l'enregistrement (PERSIST) et la mise à jour (MERGE) du client vers ses comptes associés.
    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Compte> comptes;
}