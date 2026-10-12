package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Maintenance;
import tn.esprit.tpspring.service.interfaces.IMaintenanceService;

import java.util.List;

@Tag(name = "Gestion Maintenance")
@RestController
@AllArgsConstructor
@RequestMapping("/maintenance")
public class MaintenanceRestController {

    private IMaintenanceService maintenanceService;

    // http://localhost:8089/autoloc/maintenance/retrieve-all-maintenances
    @Operation(description = "Recuperer tous les maintenances de la base de donnees")
    @GetMapping("/retrieve-all-maintenances")
    public List<Maintenance> getMaintenances() {
        List<Maintenance> listMaintenances = maintenanceService.retrieveAllMaintenances();
        return listMaintenances;
    }

    // http://localhost:8089/autoloc/maintenance/retrieve-maintenance/8
    @Operation(description = "Recuperer un maintenance par son identifiant")
    @GetMapping("/retrieve-maintenance/{maintenance-id}")
    public Maintenance retrieveMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        Maintenance maintenance = maintenanceService.retrieveMaintenance(maintenanceId);
        return maintenance;
    }

    // http://localhost:8089/autoloc/maintenance/add-maintenance
    @Operation(description = "Ajouter un nouveau maintenance")
    @PostMapping("/add-maintenance")
    public Maintenance addMaintenance(@RequestBody Maintenance c) {
        Maintenance maintenance = maintenanceService.addMaintenance(c);
        return maintenance;
    }

    // http://localhost:8089/autoloc/maintenance/remove-maintenance/8
    @Operation(description = "Supprimer un maintenance par son identifiant")
    @DeleteMapping("/remove-maintenance/{maintenance-id}")
    public void removeMaintenance(@PathVariable("maintenance-id") Long maintenanceId) {
        maintenanceService.removeMaintenance(maintenanceId);
    }

    // http://localhost:8089/autoloc/maintenance/modify-maintenance
    @Operation(description = "Modifier un maintenance existant (envoyer son identifiant)")
    @PutMapping("/modify-maintenance")
    public Maintenance modifyMaintenance(@RequestBody Maintenance c) {
        Maintenance maintenance = maintenanceService.modifyMaintenance(c);
        return maintenance;
    }
}
