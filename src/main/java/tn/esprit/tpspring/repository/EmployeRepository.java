package tn.esprit.tpspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpspring.entity.Employe;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
