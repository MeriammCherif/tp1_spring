package tn.esprit.tpspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpspring.entity.Equipement;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
