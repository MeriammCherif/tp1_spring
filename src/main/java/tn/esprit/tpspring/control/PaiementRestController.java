package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Paiement;
import tn.esprit.tpspring.service.interfaces.IPaiementService;

import java.util.List;

@Tag(name = "Gestion Paiement")
@RestController
@AllArgsConstructor
@RequestMapping("/paiement")
public class PaiementRestController {

    private IPaiementService paiementService;

    // http://localhost:8089/autoloc/paiement/retrieve-all-paiements
    @Operation(description = "Recuperer tous les paiements de la base de donnees")
    @GetMapping("/retrieve-all-paiements")
    public List<Paiement> getPaiements() {
        List<Paiement> listPaiements = paiementService.retrieveAllPaiements();
        return listPaiements;
    }

    // http://localhost:8089/autoloc/paiement/retrieve-paiement/8
    @Operation(description = "Recuperer un paiement par son identifiant")
    @GetMapping("/retrieve-paiement/{paiement-id}")
    public Paiement retrievePaiement(@PathVariable("paiement-id") Long paiementId) {
        Paiement paiement = paiementService.retrievePaiement(paiementId);
        return paiement;
    }

    // http://localhost:8089/autoloc/paiement/add-paiement
    @Operation(description = "Ajouter un nouveau paiement")
    @PostMapping("/add-paiement")
    public Paiement addPaiement(@RequestBody Paiement c) {
        Paiement paiement = paiementService.addPaiement(c);
        return paiement;
    }

    // http://localhost:8089/autoloc/paiement/remove-paiement/8
    @Operation(description = "Supprimer un paiement par son identifiant")
    @DeleteMapping("/remove-paiement/{paiement-id}")
    public void removePaiement(@PathVariable("paiement-id") Long paiementId) {
        paiementService.removePaiement(paiementId);
    }

    // http://localhost:8089/autoloc/paiement/modify-paiement
    @Operation(description = "Modifier un paiement existant (envoyer son identifiant)")
    @PutMapping("/modify-paiement")
    public Paiement modifyPaiement(@RequestBody Paiement c) {
        Paiement paiement = paiementService.modifyPaiement(c);
        return paiement;
    }
}
