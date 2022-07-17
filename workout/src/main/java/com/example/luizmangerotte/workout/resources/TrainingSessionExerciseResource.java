package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.TrainingSessionExercise;
import com.example.luizmangerotte.workout.services.TrainingSessionExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/training-session-exercise")
public class TrainingSessionExerciseResource {

    @Autowired
    TrainingSessionExerciseService trainingSessionExerciseService;

    @GetMapping
    public ResponseEntity<List<TrainingSessionExercise>> findAll(){
        return ResponseEntity.ok().body(trainingSessionExerciseService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<TrainingSessionExercise>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(trainingSessionExerciseService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TrainingSessionExercise> insert(@RequestBody TrainingSessionExercise trainingSessionExercise){
        return new ResponseEntity<>(trainingSessionExerciseService.insert(trainingSessionExercise), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainingSessionExerciseService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<TrainingSessionExercise> update(@PathVariable Long id, @RequestBody TrainingSessionExercise trainingSessionExercise){
        return ResponseEntity.ok().body(trainingSessionExercise = trainingSessionExerciseService.update(id, trainingSessionExercise));
    }

}
