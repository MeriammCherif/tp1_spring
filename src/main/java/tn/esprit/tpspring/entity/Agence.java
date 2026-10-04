package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    private String nom;
    private String ville;
    private String adresse;
    private String telephone;

    // Une Agence a plusieurs Employes (1,*)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Employe> employes;

    // Une Agence a plusieurs Vehicules (1,*)
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Vehicule> vehicules;
}
