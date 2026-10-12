package tn.esprit.tpspring.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpspring.entity.Contrat;
import tn.esprit.tpspring.repository.ContratRepository;
import tn.esprit.tpspring.service.interfaces.IContratService;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private ContratRepository contratRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat retrieveContrat(Long contratId) {
        return contratRepository.findById(contratId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Contrat introuvable avec l'id " + contratId));
    }

    @Override
    public Contrat addContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void removeContrat(Long contratId) {
        contratRepository.deleteById(contratId);
    }

    @Override
    public Contrat modifyContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }
}
