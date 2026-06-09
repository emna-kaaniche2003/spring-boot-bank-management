package tn.enis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enis.entity.Compte;
import tn.enis.dao.CompteRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CompteService {

    private final CompteRepository compteRepository;

    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    public Compte findById(Integer rib) {
        return compteRepository.findById(rib)
                .orElseThrow(() -> new RuntimeException("Compte introuvable : " + rib));
    }

    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    public void deleteById(Integer rib) {
        compteRepository.deleteById(rib);
    }

   }