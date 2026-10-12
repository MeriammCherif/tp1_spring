package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Agence;
import tn.esprit.tpspring.service.interfaces.IAgenceService;

import java.util.List;

@Tag(name = "Gestion Agence")
@RestController
@AllArgsConstructor
@RequestMapping("/agence")
public class AgenceRestController {

    private IAgenceService agenceService;

    // http://localhost:8089/autoloc/agence/retrieve-all-agences
    @Operation(description = "Recuperer tous les agences de la base de donnees")
    @GetMapping("/retrieve-all-agences")
    public List<Agence> getAgences() {
        List<Agence> listAgences = agenceService.retrieveAllAgences();
        return listAgences;
    }

    // http://localhost:8089/autoloc/agence/retrieve-agence/8
    @Operation(description = "Recuperer un agence par son identifiant")
    @GetMapping("/retrieve-agence/{agence-id}")
    public Agence retrieveAgence(@PathVariable("agence-id") Long agenceId) {
        Agence agence = agenceService.retrieveAgence(agenceId);
        return agence;
    }

    // http://localhost:8089/autoloc/agence/add-agence
    @Operation(description = "Ajouter un nouveau agence")
    @PostMapping("/add-agence")
    public Agence addAgence(@RequestBody Agence c) {
        Agence agence = agenceService.addAgence(c);
        return agence;
    }

    // http://localhost:8089/autoloc/agence/remove-agence/8
    @Operation(description = "Supprimer un agence par son identifiant")
    @DeleteMapping("/remove-agence/{agence-id}")
    public void removeAgence(@PathVariable("agence-id") Long agenceId) {
        agenceService.removeAgence(agenceId);
    }

    // http://localhost:8089/autoloc/agence/modify-agence
    @Operation(description = "Modifier un agence existant (envoyer son identifiant)")
    @PutMapping("/modify-agence")
    public Agence modifyAgence(@RequestBody Agence c) {
        Agence agence = agenceService.modifyAgence(c);
        return agence;
    }
}
