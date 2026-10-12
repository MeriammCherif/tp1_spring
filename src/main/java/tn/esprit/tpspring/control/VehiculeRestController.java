package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Vehicule;
import tn.esprit.tpspring.service.interfaces.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion Vehicule")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicule")
public class VehiculeRestController {

    private IVehiculeService vehiculeService;

    // http://localhost:8089/autoloc/vehicule/retrieve-all-vehicules
    @Operation(description = "Recuperer tous les vehicules de la base de donnees")
    @GetMapping("/retrieve-all-vehicules")
    public List<Vehicule> getVehicules() {
        List<Vehicule> listVehicules = vehiculeService.retrieveAllVehicules();
        return listVehicules;
    }

    // http://localhost:8089/autoloc/vehicule/retrieve-vehicule/8
    @Operation(description = "Recuperer un vehicule par son identifiant")
    @GetMapping("/retrieve-vehicule/{vehicule-id}")
    public Vehicule retrieveVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        Vehicule vehicule = vehiculeService.retrieveVehicule(vehiculeId);
        return vehicule;
    }

    // http://localhost:8089/autoloc/vehicule/add-vehicule
    @Operation(description = "Ajouter un nouveau vehicule")
    @PostMapping("/add-vehicule")
    public Vehicule addVehicule(@RequestBody Vehicule c) {
        Vehicule vehicule = vehiculeService.addVehicule(c);
        return vehicule;
    }

    // http://localhost:8089/autoloc/vehicule/remove-vehicule/8
    @Operation(description = "Supprimer un vehicule par son identifiant")
    @DeleteMapping("/remove-vehicule/{vehicule-id}")
    public void removeVehicule(@PathVariable("vehicule-id") Long vehiculeId) {
        vehiculeService.removeVehicule(vehiculeId);
    }

    // http://localhost:8089/autoloc/vehicule/modify-vehicule
    @Operation(description = "Modifier un vehicule existant (envoyer son identifiant)")
    @PutMapping("/modify-vehicule")
    public Vehicule modifyVehicule(@RequestBody Vehicule c) {
        Vehicule vehicule = vehiculeService.modifyVehicule(c);
        return vehicule;
    }
}
