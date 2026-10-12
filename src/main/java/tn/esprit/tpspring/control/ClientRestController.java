package tn.esprit.tpspring.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpspring.entity.Client;
import tn.esprit.tpspring.service.interfaces.IClientService;

import java.util.List;

@Tag(name = "Gestion Client")
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientRestController {

    private IClientService clientService;

    // http://localhost:8089/autoloc/client/retrieve-all-clients
    @Operation(description = "Recuperer tous les clients de la base de donnees")
    @GetMapping("/retrieve-all-clients")
    public List<Client> getClients() {
        List<Client> listClients = clientService.retrieveAllClients();
        return listClients;
    }

    // http://localhost:8089/autoloc/client/retrieve-client/8
    @Operation(description = "Recuperer un client par son identifiant")
    @GetMapping("/retrieve-client/{client-id}")
    public Client retrieveClient(@PathVariable("client-id") Long clientId) {
        Client client = clientService.retrieveClient(clientId);
        return client;
    }

    // http://localhost:8089/autoloc/client/add-client
    @Operation(description = "Ajouter un nouveau client")
    @PostMapping("/add-client")
    public Client addClient(@RequestBody Client c) {
        Client client = clientService.addClient(c);
        return client;
    }

    // http://localhost:8089/autoloc/client/remove-client/8
    @Operation(description = "Supprimer un client par son identifiant")
    @DeleteMapping("/remove-client/{client-id}")
    public void removeClient(@PathVariable("client-id") Long clientId) {
        clientService.removeClient(clientId);
    }

    // http://localhost:8089/autoloc/client/modify-client
    @Operation(description = "Modifier un client existant (envoyer son identifiant)")
    @PutMapping("/modify-client")
    public Client modifyClient(@RequestBody Client c) {
        Client client = clientService.modifyClient(c);
        return client;
    }
}
