package tn.esprit.tpspring.service.interfaces;

import tn.esprit.tpspring.entity.Client;

import java.util.List;

public interface IClientService {

    List<Client> retrieveAllClients();

    Client retrieveClient(Long clientId);

    Client addClient(Client client);

    void removeClient(Long clientId);

    Client modifyClient(Client client);
}
