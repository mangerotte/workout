package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.Macrocycle;
import com.example.luizmangerotte.workout.services.impl.MacrocycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/macrocycle")
public class MacrocycleResource {

    @Autowired
    MacrocycleServiceImpl macrocycleServiceImpl;

    @GetMapping
    public ResponseEntity<List<Macrocycle>> findAll(){
        List<Macrocycle> listMacrocycles = macrocycleServiceImpl.findAll();
        return ResponseEntity.ok().body(listMacrocycles);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Macrocycle> findById(@PathVariable Long id) {
        Macrocycle obj = macrocycleServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Macrocycle> insert(@RequestBody Macrocycle macrocycle){
        Macrocycle obj = macrocycleServiceImpl.insert(macrocycle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
