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
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<ClientDtoReponse> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(this::convertToClientDtoResponse)
                .toList();
    }

    public Optional<ClientDtoReponse> findById(Long id) {
        return Optional.ofNullable(clientRepository
                .findById(id)
                .map(this::convertToClientDtoResponse)
                .orElseThrow(() -> new ResourceNotFoundException(id)));
    }

    public List<ClientDtoReponse> findClientActive() {
        return clientRepository
                .findAll()
                .stream()
                .filter(client -> client.isStatus())
                .map(this::convertToClientDtoResponse)
                .toList();
    }

    public Integer numberClientActive() {
        return clientRepository.findAll().
                stream()
                .filter(client -> client.isStatus())
                .map(this::convertToClientDtoResponse)
                .toList()
                .size();
    }

    public Client insert(Client client){
       return clientRepository.save(convertDtoRequestToClient(convertToClientDtoRequest(client)));
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

    public Client update(Long id, Client clientRequest){
        Client clientDb = clientRepository.getReferenceById(id);
        updateData(clientDb, clientRequest);
        return clientRepository.save(clientDb);
    }
    private void updateData(Client clientDb, Client clientRequest) {
        clientDb.setName(clientRequest.getName());
        clientDb.setStatus(clientRequest.isStatus());
       clientDb.setStartDate(clientRequest.getStartDate());
        clientDb.setEmail(clientRequest.getEmail());
        clientDb.setGender(clientRequest.getGender());
    }
    public Client convertDtoRequestToClient(ClientDtoRequest clientDtoRequest){
        return modelMapper.map(clientDtoRequest, Client.class);
    }
    public ClientDtoRequest convertToClientDtoRequest(Client client){
       return modelMapper.map(client, ClientDtoRequest.class);
    }
    public ClientDtoReponse convertToClientDtoResponse(Client client){
        return modelMapper.map(client, ClientDtoReponse.class);
    }
}
