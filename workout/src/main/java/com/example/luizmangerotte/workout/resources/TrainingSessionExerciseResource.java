package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.TrainingSessionExercise;
import com.example.luizmangerotte.workout.services.impl.TrainingSessionExerciseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/training-session-exercise")
public class TrainingSessionExerciseResource {

    @Autowired
    TrainingSessionExerciseServiceImpl trainingSessionExerciseServiceImpl;

    @GetMapping
    public ResponseEntity<List<TrainingSessionExercise>> findAll(){
        List<TrainingSessionExercise> trainingSessionExerciseList = trainingSessionExerciseServiceImpl.findAll();
        return ResponseEntity.ok().body(trainingSessionExerciseList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingSessionExercise> findById(@PathVariable Long id) {
        TrainingSessionExercise obj = trainingSessionExerciseServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TrainingSessionExercise> insert(@RequestBody TrainingSessionExercise trainingSessionExercise){
        TrainingSessionExercise obj = trainingSessionExerciseServiceImpl.insert(trainingSessionExercise);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
