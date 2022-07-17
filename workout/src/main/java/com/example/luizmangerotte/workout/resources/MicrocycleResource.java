package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.Microcycle;
import com.example.luizmangerotte.workout.services.MicrocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/microcycle")
public class MicrocycleResource {

    @Autowired
    MicrocycleService microcycleService;

    @GetMapping
    public ResponseEntity<List<Microcycle>> findAll(){
        return ResponseEntity.ok().body(microcycleService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Microcycle>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(microcycleService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Microcycle> insert(@RequestBody Microcycle microcycle){
        return new ResponseEntity<>(microcycleService.insert(microcycle), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        microcycleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Microcycle> update(@PathVariable Long id, @RequestBody Microcycle microcycle){
        return ResponseEntity.ok().body(microcycle = microcycleService.update(id, microcycle));
    }

}
