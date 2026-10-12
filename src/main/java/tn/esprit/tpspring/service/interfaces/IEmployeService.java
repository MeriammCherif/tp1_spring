package tn.esprit.tpspring.service.interfaces;

import tn.esprit.tpspring.entity.Employe;

import java.util.List;

public interface IEmployeService {

    List<Employe> retrieveAllEmployes();

    Employe retrieveEmploye(Long employeId);

    Employe addEmploye(Employe employe);

    void removeEmploye(Long employeId);

    Employe modifyEmploye(Employe employe);
}
