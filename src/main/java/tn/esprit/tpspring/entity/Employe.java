package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import tn.esprit.tpspring.entity.RoleEmploye;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmploye;

    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private RoleEmploye role;

    // Plusieurs Employes appartiennent a une Agence (*,1)
    @ManyToOne
    @JoinColumn(name = "id_agence")
    @JsonIgnore
    private Agence agence;
}
