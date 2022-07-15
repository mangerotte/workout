package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.dto.response.ClientDtoReponse;
import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    ClientServiceImpl clientServiceImpl;

    @GetMapping
    public ResponseEntity<List<ClientDtoReponse>> findAll(){
        return ResponseEntity.ok().body(clientServiceImpl.findAll());
    }

    @GetMapping
    @RequestMapping(value="/active")
    public ResponseEntity<List<ClientDtoReponse>> findActive() {
        return ResponseEntity.ok().body(clientServiceImpl.findClientActive());
    }

    @GetMapping
    @RequestMapping(value="/number-active")
    public ResponseEntity<Integer> numberActive() {
        return ResponseEntity.ok().body(clientServiceImpl.numberClientActive());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<ClientDtoReponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientServiceImpl.findById(id));
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client client){
        return new ResponseEntity<>(clientServiceImpl.insert(client), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientServiceImpl.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        return ResponseEntity.ok().body(client = clientServiceImpl.update(id, client));
    }


}
