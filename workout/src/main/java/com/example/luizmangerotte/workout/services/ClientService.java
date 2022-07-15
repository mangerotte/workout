package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.dto.request.ClientDtoRequest;
import com.example.luizmangerotte.workout.dto.response.ClientDtoReponse;
import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.repositories.ClientRepository;
import com.example.luizmangerotte.workout.services.exceptions.DataBaseException;
import com.example.luizmangerotte.workout.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ClientDtoReponse> findAll() {
        List<ClientDtoReponse> clientDtoReponseList = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll();
        clientList.forEach(client -> clientDtoReponseList.add(convertToClientDtO(client)));
        return clientDtoReponseList;
    }

    public ClientDtoReponse findById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        ClientDtoReponse clientDtoReponse = convertToClientDtO(client.orElseThrow(() -> new ResourceNotFoundException(id)));
        Optional<ClientDtoReponse> obj = Optional.of(clientDtoReponse);
        return obj.get();
    }

    public List<ClientDtoReponse> findClientActive() {
        List<ClientDtoReponse> clientDtoReponseList = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll().stream().filter(x -> x.isStatus()).collect(Collectors.toList());
        clientList.forEach(client -> clientDtoReponseList.add(convertToClientDtO(client)));
        return clientDtoReponseList;
    }

    public Integer numberClientActive() {
        List<ClientDtoReponse> clientDtoReponseList = new ArrayList<>();
        List<Client> clientList = clientRepository.findAll().stream().filter(x -> x.isStatus()).collect(Collectors.toList());
        clientList.forEach(client -> clientDtoReponseList.add(convertToClientDtO(client)));
        return clientList.size();
    }

    public Client insert(Client client){
        return clientRepository.save(client);
    }

    public void delete(Long id) {
        try {
            clientRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
                throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

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
    public Client convertToClient(ClientDtoRequest clientDtoRequest){
        Client client = modelMapper.map(clientDtoRequest, Client.class);
        return client;
    }

    public ClientDtoReponse convertToClientDtO(Client client){
        ClientDtoReponse clientDtoReponse = modelMapper.map(client, ClientDtoReponse.class);
        return clientDtoReponse;
    }
}
