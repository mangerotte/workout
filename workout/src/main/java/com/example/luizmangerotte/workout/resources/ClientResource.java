package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.Client;
import com.example.luizmangerotte.workout.model.dto.ClientDto;
import com.example.luizmangerotte.workout.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<ClientDto>> findAll(){
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    public ResponseEntity<Optional<ClientDto>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Client> insert(@RequestBody ClientDto obj){
        return new ResponseEntity<>(clientService.insert(obj), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('USER', 'ADMIN')")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        return ResponseEntity.ok().body(clientService.update(id, client));
    }
}
