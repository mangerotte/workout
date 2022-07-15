package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.SetExercise;
import com.example.luizmangerotte.workout.services.impl.SetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/set")
public class SetResource {

    @Autowired
    SetServiceImpl setServiceImpl;

    @GetMapping
    public ResponseEntity<List<SetExercise>> findAll(){
        List<SetExercise> setExerciseList = setServiceImpl.findAll();
        return ResponseEntity.ok().body(setExerciseList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SetExercise> findById(@PathVariable Long id) {
        SetExercise obj = setServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<SetExercise> insert(@RequestBody SetExercise setExercise){
        SetExercise obj = setServiceImpl.insert(setExercise);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
