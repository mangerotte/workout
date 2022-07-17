package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.SetExercise;
import com.example.luizmangerotte.workout.services.SetExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/set")
public class SetExerciseResource {

    @Autowired
    SetExerciseService setExerciseService;

    @GetMapping
    public ResponseEntity<List<SetExercise>> findAll(){
        return ResponseEntity.ok().body(setExerciseService.findAll());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<SetExercise>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(setExerciseService.findById(id));
    }
    @PostMapping
    public ResponseEntity<SetExercise> insert(@RequestBody SetExercise setExercise){
        return new ResponseEntity<>(setExerciseService.insert(setExercise), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        setExerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<SetExercise> update(@PathVariable Long id, @RequestBody SetExercise setExercise){
        return ResponseEntity.ok().body(setExercise = setExerciseService.update(id, setExercise));
    }
}
