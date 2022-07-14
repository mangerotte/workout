package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.TrainingSession;
import com.example.luizmangerotte.workout.entities.enums.MuscleGroup;
import com.example.luizmangerotte.workout.services.TrainingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/training-session")
public class TrainingSessionResource {

    @Autowired
    TrainingSessionService trainingSessionService;

    @GetMapping
    public ResponseEntity<List<TrainingSession>> findAll(){
        List<TrainingSession> listTrainingSession = trainingSessionService.findAll();
        return ResponseEntity.ok().body(listTrainingSession);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingSession> findById(@PathVariable Long id) {
        TrainingSession obj = trainingSessionService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}/{muscle-group}")
    public ResponseEntity<Integer> getSetGroup(@PathVariable Long id, @PathVariable MuscleGroup muscleGroup){
        Integer obj = trainingSessionService.getSetGroup(id, muscleGroup);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TrainingSession> insert(@RequestBody TrainingSession trainingSession){
        TrainingSession obj = trainingSessionService.insert(trainingSession);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
