package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.Exercise;
import com.example.luizmangerotte.workout.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/exercise")
public class ExerciseResource {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> findAll(){
        return ResponseEntity.ok().body(exerciseService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Exercise>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(exerciseService.findById(id));}

    @PostMapping
    public ResponseEntity<Exercise> insert(@RequestBody Exercise exercise){
        return new ResponseEntity<>(exerciseService.insert(exercise), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        exerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Exercise> update(@PathVariable Long id, @RequestBody Exercise exercise){
        return ResponseEntity.ok().body(exercise = exerciseService.update(id, exercise));
    }
}


