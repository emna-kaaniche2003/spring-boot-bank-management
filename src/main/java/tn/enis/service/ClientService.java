package tn.enis.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enis.entity.Client;
import tn.enis.dao.ClientRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(String cin) {
        return clientRepository.findById(cin)
                .orElseThrow(() -> new RuntimeException("Client introuvable : " + cin));
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void deleteById(String cin) {
        clientRepository.deleteById(cin);
    }

    public List<Client> search(String term) {
        return clientRepository.searchByTerm(term);
    }

}