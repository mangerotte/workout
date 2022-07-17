package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.model.TrainingSession;
import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.example.luizmangerotte.workout.services.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/training-session")
public class TrainingSessionResource {

    @Autowired
    TrainingSessionService trainingSessionService;

    @GetMapping
    public ResponseEntity<List<TrainingSession>> findAll(){
        return ResponseEntity.ok().body(trainingSessionService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<TrainingSession>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(trainingSessionService.findById(id));
    }

    @GetMapping(value = "/{id}/{muscle-group}")
    public ResponseEntity<Optional<Integer>> getSetGroup(@PathVariable Long id, @PathVariable MuscleGroup muscleGroup){
        return ResponseEntity.ok().body(trainingSessionService.getSetGroup(id, muscleGroup));
    }

    public ResponseEntity<Optional<Double>> getVolumeLoad(Long id){
        return ResponseEntity.ok().body(trainingSessionService.getVolumeLoad(id));
    }

    @PostMapping
    public ResponseEntity<TrainingSession> insert(@RequestBody TrainingSession trainingSession){
        return new ResponseEntity<>(trainingSessionService.insert(trainingSession), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        trainingSessionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TrainingSession> update(@PathVariable Long id, @RequestBody TrainingSession trainingSession){
        return ResponseEntity.ok().body(trainingSession = trainingSessionService.update(id, trainingSession));
    }

}
