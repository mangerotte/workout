package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.Exercise;
import com.example.luizmangerotte.workout.services.impl.ExerciseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/exercise")
public class ExerciseResource {

    @Autowired
    ExerciseServiceImpl exerciseServiceImpl;

    @GetMapping
    public ResponseEntity<List<Exercise>> findAll(){
        List<Exercise> listExercises = exerciseServiceImpl.findAll();
        return ResponseEntity.ok().body(listExercises);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exercise> findById(@PathVariable Long id) {
        Exercise obj = exerciseServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);}

    @PostMapping
    public ResponseEntity<Exercise> insert(@RequestBody Exercise exercise){
        Exercise obj = exerciseServiceImpl.insert(exercise);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}


