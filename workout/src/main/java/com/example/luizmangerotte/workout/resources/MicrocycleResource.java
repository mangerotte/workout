package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.Microcycle;
import com.example.luizmangerotte.workout.services.impl.MicrocycleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/microcycle")
public class MicrocycleResource {

    @Autowired
    MicrocycleServiceImpl microcycleServiceImpl;

    @GetMapping
    public ResponseEntity<List<Microcycle>> findAll(){
        List<Microcycle> listMicrocycles = microcycleServiceImpl.findAll();
        return ResponseEntity.ok().body(listMicrocycles);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Microcycle> findById(@PathVariable Long id) {
        Microcycle obj = microcycleServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Microcycle> insert(@RequestBody Microcycle microcycle){
        Microcycle obj = microcycleServiceImpl.insert(microcycle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
