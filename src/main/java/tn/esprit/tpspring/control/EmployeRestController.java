package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Employe;
import tn.esprit.tpspring.service.interfaces.IEmployeService;

import java.util.List;

@Tag(name = "Gestion Employe")
@RestController
@AllArgsConstructor
@RequestMapping("/employe")
public class EmployeRestController {

    private IEmployeService employeService;

    // http://localhost:8089/autoloc/employe/retrieve-all-employes
    @Operation(description = "Recuperer tous les employes de la base de donnees")
    @GetMapping("/retrieve-all-employes")
    public List<Employe> getEmployes() {
        List<Employe> listEmployes = employeService.retrieveAllEmployes();
        return listEmployes;
    }

    // http://localhost:8089/autoloc/employe/retrieve-employe/8
    @Operation(description = "Recuperer un employe par son identifiant")
    @GetMapping("/retrieve-employe/{employe-id}")
    public Employe retrieveEmploye(@PathVariable("employe-id") Long employeId) {
        Employe employe = employeService.retrieveEmploye(employeId);
        return employe;
    }

    // http://localhost:8089/autoloc/employe/add-employe
    @Operation(description = "Ajouter un nouveau employe")
    @PostMapping("/add-employe")
    public Employe addEmploye(@RequestBody Employe c) {
        Employe employe = employeService.addEmploye(c);
        return employe;
    }

    // http://localhost:8089/autoloc/employe/remove-employe/8
    @Operation(description = "Supprimer un employe par son identifiant")
    @DeleteMapping("/remove-employe/{employe-id}")
    public void removeEmploye(@PathVariable("employe-id") Long employeId) {
        employeService.removeEmploye(employeId);
    }

    // http://localhost:8089/autoloc/employe/modify-employe
    @Operation(description = "Modifier un employe existant (envoyer son identifiant)")
    @PutMapping("/modify-employe")
    public Employe modifyEmploye(@RequestBody Employe c) {
        Employe employe = employeService.modifyEmploye(c);
        return employe;
    }
}
