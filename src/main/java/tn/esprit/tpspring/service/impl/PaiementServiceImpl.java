package tn.esprit.tpspring.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpspring.entity.Paiement;
import tn.esprit.tpspring.repository.PaiementRepository;
import tn.esprit.tpspring.service.interfaces.IPaiementService;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private PaiementRepository paiementRepository;

    @Override
    public List<Paiement> retrieveAllPaiements() {
        return paiementRepository.findAll();
    }

    @Override
    public Paiement retrievePaiement(Long paiementId) {
        return paiementRepository.findById(paiementId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Paiement introuvable avec l'id " + paiementId));
    }

    @Override
    public Paiement addPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public void removePaiement(Long paiementId) {
        paiementRepository.deleteById(paiementId);
    }

    @Override
    public Paiement modifyPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }
}
