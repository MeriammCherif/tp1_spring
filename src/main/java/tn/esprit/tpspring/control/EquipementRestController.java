package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Equipement;
import tn.esprit.tpspring.service.interfaces.IEquipementService;

import java.util.List;

@Tag(name = "Gestion Equipement")
@RestController
@AllArgsConstructor
@RequestMapping("/equipement")
public class EquipementRestController {

    private IEquipementService equipementService;

    // http://localhost:8089/autoloc/equipement/retrieve-all-equipements
    @Operation(description = "Recuperer tous les equipements de la base de donnees")
    @GetMapping("/retrieve-all-equipements")
    public List<Equipement> getEquipements() {
        List<Equipement> listEquipements = equipementService.retrieveAllEquipements();
        return listEquipements;
    }

    // http://localhost:8089/autoloc/equipement/retrieve-equipement/8
    @Operation(description = "Recuperer un equipement par son identifiant")
    @GetMapping("/retrieve-equipement/{equipement-id}")
    public Equipement retrieveEquipement(@PathVariable("equipement-id") Long equipementId) {
        Equipement equipement = equipementService.retrieveEquipement(equipementId);
        return equipement;
    }

    // http://localhost:8089/autoloc/equipement/add-equipement
    @Operation(description = "Ajouter un nouveau equipement")
    @PostMapping("/add-equipement")
    public Equipement addEquipement(@RequestBody Equipement c) {
        Equipement equipement = equipementService.addEquipement(c);
        return equipement;
    }

    // http://localhost:8089/autoloc/equipement/remove-equipement/8
    @Operation(description = "Supprimer un equipement par son identifiant")
    @DeleteMapping("/remove-equipement/{equipement-id}")
    public void removeEquipement(@PathVariable("equipement-id") Long equipementId) {
        equipementService.removeEquipement(equipementId);
    }

    // http://localhost:8089/autoloc/equipement/modify-equipement
    @Operation(description = "Modifier un equipement existant (envoyer son identifiant)")
    @PutMapping("/modify-equipement")
    public Equipement modifyEquipement(@RequestBody Equipement c) {
        Equipement equipement = equipementService.modifyEquipement(c);
        return equipement;
    }
}
