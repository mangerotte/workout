package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.Client;
import com.example.luizmangerotte.workout.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientResource {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll(){
        List<Client> clientList = clientService.findAll();
        return ResponseEntity.ok().body(clientList);
    }

    @GetMapping
    @RequestMapping(value="/active-client")
    public ResponseEntity<List<Client>> findActive() {
        List<Client> activeList = clientService.findClientActive();
        return ResponseEntity.ok().body(activeList);
    }

    @GetMapping
    @RequestMapping(value="/number-active-client")
    public ResponseEntity<Integer> numberActive() {
        Integer numberActiveClient = clientService.numberClientActive();
        return ResponseEntity.ok().body(numberActiveClient);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Client> insert(@RequestBody Client obj){
        obj = clientService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client obj){
        obj = clientService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
