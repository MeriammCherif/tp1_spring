package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    // Plusieurs Maintenances appartiennent a un Vehicule (*,1)
    @ManyToOne
    @JoinColumn(name = "id_vehicule")
    @JsonIgnore
    private Vehicule vehicule;
}
