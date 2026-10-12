package tn.esprit.tpspring.service.interfaces;

import tn.esprit.tpspring.entity.Equipement;

import java.util.List;

public interface IEquipementService {

    List<Equipement> retrieveAllEquipements();

    Equipement retrieveEquipement(Long equipementId);

    Equipement addEquipement(Equipement equipement);

    void removeEquipement(Long equipementId);

    Equipement modifyEquipement(Equipement equipement);
}
