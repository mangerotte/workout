package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.Macrocycle;
import com.example.luizmangerotte.workout.services.MacrocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/macrocycle")
public class MacrocycleResource {

    @Autowired
    MacrocycleService macrocycleService;

    @GetMapping
    public ResponseEntity<List<Macrocycle>> findAll(){
        return ResponseEntity.ok().body(macrocycleService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Macrocycle>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(macrocycleService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Macrocycle> insert(@RequestBody Macrocycle macrocycle){
        return new ResponseEntity<>(macrocycleService.insert(macrocycle), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        macrocycleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Macrocycle> update(@PathVariable Long id, @RequestBody Macrocycle macrocycle){
        return ResponseEntity.ok().body(macrocycle = macrocycleService.update(id, macrocycle));
    }
}
