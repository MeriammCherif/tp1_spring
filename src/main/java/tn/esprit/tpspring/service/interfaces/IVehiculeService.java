package tn.esprit.tpspring.service.interfaces;

import tn.esprit.tpspring.entity.Vehicule;

import java.util.List;

public interface IVehiculeService {

    List<Vehicule> retrieveAllVehicules();

    Vehicule retrieveVehicule(Long vehiculeId);

    Vehicule addVehicule(Vehicule vehicule);

    void removeVehicule(Long vehiculeId);

    Vehicule modifyVehicule(Vehicule vehicule);
}
