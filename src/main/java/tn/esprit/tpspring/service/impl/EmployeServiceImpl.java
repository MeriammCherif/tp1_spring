package tn.esprit.tpspring.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.tpspring.entity.Employe;
import tn.esprit.tpspring.repository.EmployeRepository;
import tn.esprit.tpspring.service.interfaces.IEmployeService;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private EmployeRepository employeRepository;

    @Override
    public List<Employe> retrieveAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe retrieveEmploye(Long employeId) {
        return employeRepository.findById(employeId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employe introuvable avec l'id " + employeId));
    }

    @Override
    public Employe addEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public void removeEmploye(Long employeId) {
        employeRepository.deleteById(employeId);
    }

    @Override
    public Employe modifyEmploye(Employe employe) {
        return employeRepository.save(employe);
    }
}
