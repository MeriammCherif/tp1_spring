package tn.esprit.tpspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tpspring.entity.ModePaiement;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaiement;

    private BigDecimal montant;
    private LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    private ModePaiement modePaiement;

    // Plusieurs Paiements appartiennent a un seul Contrat (*,1)
    @ManyToOne
    @JoinColumn(name = "id_contrat")
    @JsonIgnore
    private Contrat contrat;
}
