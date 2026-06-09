package tn.enis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.enis.entity.Client;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    // se proteger contre les injections sql
    @Query("SELECT c FROM Client c WHERE LOWER(c.nom) LIKE LOWER(CONCAT('%', :term, '%')) " +
            "OR LOWER(c.prenom) LIKE LOWER(CONCAT('%', :term, '%')) " +
            "OR LOWER(c.cin) LIKE LOWER(CONCAT('%', :term, '%'))")
    List<Client> searchByTerm(@Param("term") String term);
}