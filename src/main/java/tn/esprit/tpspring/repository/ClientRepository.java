package tn.esprit.tpspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tpspring.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
