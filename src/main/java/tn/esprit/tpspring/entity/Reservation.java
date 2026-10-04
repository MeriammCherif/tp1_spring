package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tpspring.entity.StatutReservation;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // Plusieurs Reservations pour un Vehicule (*,1)
    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    @JsonIgnore
    private Vehicule vehicule;

    // Plusieurs Reservations pour un Client (*,1)
    @ManyToOne
    @JoinColumn(name = "id_client")
    @JsonIgnore
    private Client client;

    // Une Reservation correspond a un seul Contrat (1,1)
    // Reservation est proprietaire de la relation -> porte la cle etrangere id_contrat
    @OneToOne
    @JoinColumn(name = "id_contrat")
    private Contrat contrat;
}
