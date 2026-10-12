package tn.esprit.tpspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpspring.entity.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
