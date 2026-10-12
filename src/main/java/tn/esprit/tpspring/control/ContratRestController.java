package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Contrat;
import tn.esprit.tpspring.service.interfaces.IContratService;

import java.util.List;

@Tag(name = "Gestion Contrat")
@RestController
@AllArgsConstructor
@RequestMapping("/contrat")
public class ContratRestController {

    private IContratService contratService;

    // http://localhost:8089/autoloc/contrat/retrieve-all-contrats
    @Operation(description = "Recuperer tous les contrats de la base de donnees")
    @GetMapping("/retrieve-all-contrats")
    public List<Contrat> getContrats() {
        List<Contrat> listContrats = contratService.retrieveAllContrats();
        return listContrats;
    }

    // http://localhost:8089/autoloc/contrat/retrieve-contrat/8
    @Operation(description = "Recuperer un contrat par son identifiant")
    @GetMapping("/retrieve-contrat/{contrat-id}")
    public Contrat retrieveContrat(@PathVariable("contrat-id") Long contratId) {
        Contrat contrat = contratService.retrieveContrat(contratId);
        return contrat;
    }

    // http://localhost:8089/autoloc/contrat/add-contrat
    @Operation(description = "Ajouter un nouveau contrat")
    @PostMapping("/add-contrat")
    public Contrat addContrat(@RequestBody Contrat c) {
        Contrat contrat = contratService.addContrat(c);
        return contrat;
    }

    // http://localhost:8089/autoloc/contrat/remove-contrat/8
    @Operation(description = "Supprimer un contrat par son identifiant")
    @DeleteMapping("/remove-contrat/{contrat-id}")
    public void removeContrat(@PathVariable("contrat-id") Long contratId) {
        contratService.removeContrat(contratId);
    }

    // http://localhost:8089/autoloc/contrat/modify-contrat
    @Operation(description = "Modifier un contrat existant (envoyer son identifiant)")
    @PutMapping("/modify-contrat")
    public Contrat modifyContrat(@RequestBody Contrat c) {
        Contrat contrat = contratService.modifyContrat(c);
        return contrat;
    }
}
