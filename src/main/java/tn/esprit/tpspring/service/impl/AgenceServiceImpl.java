package tn.esprit.tpspring.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpspring.entity.Agence;
import tn.esprit.tpspring.repository.AgenceRepository;
import tn.esprit.tpspring.service.interfaces.IAgenceService;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private AgenceRepository agenceRepository;

    @Override
    public List<Agence> retrieveAllAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence retrieveAgence(Long agenceId) {
        return agenceRepository.findById(agenceId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Agence introuvable avec l'id " + agenceId));
    }

    @Override
    public Agence addAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public void removeAgence(Long agenceId) {
        agenceRepository.deleteById(agenceId);
    }

    @Override
    public Agence modifyAgence(Agence agence) {
        return agenceRepository.save(agence);
    }
}
