package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private Boolean valide;

    // Cote inverse (non proprietaire) du OneToOne avec Reservation
    @OneToOne(mappedBy = "contrat")
    @JsonIgnore
    private Reservation reservation;

    // Composition : un Contrat possede plusieurs Paiements (1,*)
    // orphanRemoval = true car un Paiement n'existe pas sans son Contrat (losange plein)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Paiement> paiements;
}
