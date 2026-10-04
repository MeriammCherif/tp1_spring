package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tpspring.entity.CategorieVehicule;
import tn.esprit.tpspring.entity.StatutVehicule;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // Plusieurs Vehicules appartiennent a une Agence (*,1)
    @ManyToOne
    @JoinColumn(name = "id_agence")
    @JsonIgnore
    private Agence agence;

    // Un Vehicule a plusieurs Maintenances (1,*)
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Maintenance> maintenances;

    // Un Vehicule a plusieurs Reservations (1,*)
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Reservation> reservations;

    // Plusieurs Vehicules <-> Plusieurs Equipements (*,*)
    // Vehicule est le proprietaire de la relation -> table de jointure vehicule_equipement
    @ManyToMany
    @JoinTable(
            name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "id_vehicule"),
            inverseJoinColumns = @JoinColumn(name = "id_equipement")
    )
    @JsonIgnore
    private List<Equipement> equipements;
}
