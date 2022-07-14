package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.TrainingSessionExercise;
import com.example.luizmangerotte.workout.services.TrainingSessionExerciseService;
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
    TrainingSessionExerciseService trainingSessionExerciseService;

    @GetMapping
    public ResponseEntity<List<TrainingSessionExercise>> findAll(){
        List<TrainingSessionExercise> trainingSessionExerciseList = trainingSessionExerciseService.findAll();
        return ResponseEntity.ok().body(trainingSessionExerciseList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingSessionExercise> findById(@PathVariable Long id) {
        TrainingSessionExercise obj = trainingSessionExerciseService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TrainingSessionExercise> insert(@RequestBody TrainingSessionExercise trainingSessionExercise){
        TrainingSessionExercise obj = trainingSessionExerciseService.insert(trainingSessionExercise);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
