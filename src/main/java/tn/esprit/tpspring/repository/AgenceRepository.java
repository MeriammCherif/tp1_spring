package tn.esprit.tpspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpspring.entity.Agence;

@Repository
public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
