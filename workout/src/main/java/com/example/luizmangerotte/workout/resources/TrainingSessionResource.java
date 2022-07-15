package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.TrainingSession;
import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.example.luizmangerotte.workout.services.impl.TrainingSessionServiceImpl;
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
    TrainingSessionServiceImpl trainingSessionServiceImpl;

    @GetMapping
    public ResponseEntity<List<TrainingSession>> findAll(){
        List<TrainingSession> listTrainingSession = trainingSessionServiceImpl.findAll();
        return ResponseEntity.ok().body(listTrainingSession);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainingSession> findById(@PathVariable Long id) {
        TrainingSession obj = trainingSessionServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}/{muscle-group}")
    public ResponseEntity<Integer> getSetGroup(@PathVariable Long id, @PathVariable MuscleGroup muscleGroup){
        Integer obj = trainingSessionServiceImpl.getSetGroup(id, muscleGroup);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<TrainingSession> insert(@RequestBody TrainingSession trainingSession){
        TrainingSession obj = trainingSessionServiceImpl.insert(trainingSession);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
