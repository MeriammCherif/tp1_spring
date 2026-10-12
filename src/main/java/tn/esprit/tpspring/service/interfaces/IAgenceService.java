package tn.esprit.tpspring.service.interfaces;

import tn.esprit.tpspring.entity.Agence;

import java.util.List;

public interface IAgenceService {

    List<Agence> retrieveAllAgences();

    Agence retrieveAgence(Long agenceId);

    Agence addAgence(Agence agence);

    void removeAgence(Long agenceId);

    Agence modifyAgence(Agence agence);
}
