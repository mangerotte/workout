package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.dto.request.ClientDtoRequest;
import com.example.luizmangerotte.workout.dto.response.ClientDtoReponse;
import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    ClientService clientService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<List<ClientDtoReponse>> findAll(){
        List<ClientDtoReponse> clientDtoReponseList = clientService.findAll();
        return ResponseEntity.ok().body(clientDtoReponseList);
    }

    @GetMapping
    @RequestMapping(value="/active")
    public ResponseEntity<List<ClientDtoReponse>> findActive() {
        List<ClientDtoReponse> activeList = clientService.findClientActive();
        return ResponseEntity.ok().body(activeList);
    }

    @GetMapping
    @RequestMapping(value="/number-active")
    public ResponseEntity<Integer> numberActive() {
        Integer numberActiveClient = clientService.numberClientActive();
        return ResponseEntity.ok().body(numberActiveClient);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDtoReponse> findById(@PathVariable Long id) {
        ClientDtoReponse obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody ClientDtoRequest clientDtoRequest){
        Client obj = clientService.convertToClient(clientDtoRequest);
        obj = clientService.insert(obj);
        return new ResponseEntity<>(obj, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody ClientDtoRequest clientDtoRequest){
        Client client = clientService.convertToClient(clientDtoRequest);
        client = clientService.update(id, client);
        return ResponseEntity.ok().body(client);
    }


}
