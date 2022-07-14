package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.entities.Client;
import com.example.luizmangerotte.workout.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public List<Client> findClientActive() {
        return clientRepository.findAll().stream().filter(x -> x.isStatus()).collect(Collectors.toList());
    }

    public Integer numberClientActive() {
        List<Client> listAtivos = clientRepository.findAll().stream().filter(x -> x.isStatus()).collect(Collectors.toList());
        return listAtivos.size();
    }

    public Client insert(Client aluno){
        return clientRepository.save(aluno);
    }

    public void delete(Long id) { clientRepository.deleteById(id);}

    public Client update(Long id, Client obj){
        Client entity = clientRepository.getReferenceById(id);
        updateData(entity, obj);
        return clientRepository.save(entity);
    }
    private void updateData(Client entity, Client obj) {
        entity.setName(obj.getName());
        entity.setStatus(obj.isStatus());
       entity.setStartDate(obj.getStartDate());
    }
}
