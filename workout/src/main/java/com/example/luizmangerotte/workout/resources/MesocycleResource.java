package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.Mesocycle;
import com.example.luizmangerotte.workout.services.MesocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/mesocycle")
public class MesocycleResource {

    @Autowired
    MesocycleService mesocycleService;

    @GetMapping
    public ResponseEntity<List<Mesocycle>> findAll(){
        return ResponseEntity.ok().body(mesocycleService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Mesocycle>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(mesocycleService.findById(id));
    }
    @PostMapping
    public ResponseEntity<Mesocycle> insert(@RequestBody Mesocycle mesocycle){
        return new ResponseEntity<>(mesocycleService.insert(mesocycle), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mesocycleService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Mesocycle> update(@PathVariable Long id, @RequestBody Mesocycle mesocycle){
        return ResponseEntity.ok().body(mesocycle = mesocycleService.update(id, mesocycle));
    }
    

}
