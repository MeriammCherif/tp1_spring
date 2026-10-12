package tn.esprit.tpspring.service.interfaces;

import tn.esprit.tpspring.entity.Paiement;

import java.util.List;

public interface IPaiementService {

    List<Paiement> retrieveAllPaiements();

    Paiement retrievePaiement(Long paiementId);

    Paiement addPaiement(Paiement paiement);

    void removePaiement(Long paiementId);

    Paiement modifyPaiement(Paiement paiement);
}
