package tn.enis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.entity.Compte;


@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {


}