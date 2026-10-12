package tn.esprit.tpspring.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpspring.entity.Equipement;
import tn.esprit.tpspring.repository.EquipementRepository;
import tn.esprit.tpspring.service.interfaces.IEquipementService;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private EquipementRepository equipementRepository;

    @Override
    public List<Equipement> retrieveAllEquipements() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement retrieveEquipement(Long equipementId) {
        return equipementRepository.findById(equipementId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Equipement introuvable avec l'id " + equipementId));
    }

    @Override
    public Equipement addEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public void removeEquipement(Long equipementId) {
        equipementRepository.deleteById(equipementId);
    }

    @Override
    public Equipement modifyEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }
}
