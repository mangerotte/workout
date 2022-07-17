package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.dto.request.ClientDtoRequest;
import com.example.luizmangerotte.workout.dto.response.ClientDtoReponse;
import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.repositories.ClientRepository;
import com.example.luizmangerotte.workout.services.exceptions.DataBaseException;
import com.example.luizmangerotte.workout.services.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ClientDtoReponse> findAll() {
        try {
            log.info("Returning all clients");
            return clientRepository.findAll()
                    .stream()
                    .map(this::convertToClientDtoResponse)
                    .toList();
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
}

    public Optional<ClientDtoReponse> findById(Long id) {
        try {
            log.info("Returning client id " + id);
            return Optional.of(clientRepository
                .findById(id)
                .map(this::convertToClientDtoResponse))
                .get();
        }catch (ResourceNotFoundException e){
            log.error("Not found id: " + id);
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'findById()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ClientDtoReponse> findClientActive() {
        try {
            log.info("Returning clients active");
            return clientRepository
                    .findAll()
                    .stream()
                    .filter(Client::isStatus)
                    .map(this::convertToClientDtoResponse)
                    .toList();
        } catch (ResourceNotFoundException e){
            log.error("Not found clients active");
            throw new ResourceNotFoundException(e.getMessage());
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'findClientActive()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Integer numberClientActive() {
        try {
            log.info("Returning number clients active");
            return clientRepository.findAll().
                    stream()
                    .filter(Client::isStatus)
                    .map(this::convertToClientDtoResponse)
                    .toList()
                    .size();
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'numberClientActive()'");
            throw  new RuntimeException(e.getMessage());
        }
    }

    public Client insert(Client client){
       try {
           log.info("Client successfully created");
           return clientRepository.save(convertDtoRequestToClient
                   (convertToClientDtoRequest(client)));
       } catch (RuntimeException e){
           log.error("Unexpected error in method 'insert'");
           throw new RuntimeException(e.getMessage());
       }
    }

    public void delete(Long id) {
        try {
            log.info("Client successfully deleted with id:" + id);
            clientRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            log.error("Client not found");
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'delete()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Client update(Long id, Client clientRequest){
        try {
            log.info("Client successfully update with id:" + id);
            Client clientDb = clientRepository.getReferenceById(id);
            updateData(clientDb, clientRequest);
            return clientRepository.save(clientDb);
        }catch (EntityNotFoundException e){
            log.info("Client not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
    private void updateData(Client clientDb, Client clientRequest) {
        clientDb.setName(clientRequest.getName());
        clientDb.setStatus(clientRequest.isStatus());
       clientDb.setStartDate(clientRequest.getStartDate());
        clientDb.setEmail(clientRequest.getEmail());
        clientDb.setGender(clientRequest.getGender());
    }
    public Client convertDtoRequestToClient(ClientDtoRequest clientDtoRequest){
        try {
            log.info("ClientDtoRequest converted for client successfully");
            return modelMapper.map(clientDtoRequest, Client.class);
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'convertDtoRequestToClient'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public ClientDtoRequest convertToClientDtoRequest(Client client){
       try {
           log.info("Client converted for ClientDtoRequest successfully");
           return modelMapper.map(client, ClientDtoRequest.class);
       } catch (RuntimeException e) {
           log.error("Unexpected error in method 'convertToClientDtoRequest'");
           throw new RuntimeException(e.getMessage());
       }
    }
    public ClientDtoReponse convertToClientDtoResponse(Client client){
        try {
            log.info("Client converted for ClientDtoResponse successfully");
            return modelMapper.map(client, ClientDtoReponse.class);
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'convertToClientDtoResponse'");
            throw new RuntimeException(e.getMessage());
        }
    }
}
