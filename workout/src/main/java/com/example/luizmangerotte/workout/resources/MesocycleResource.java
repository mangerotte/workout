package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.Mesocycle;
import com.example.luizmangerotte.workout.services.MesocycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/mesocycle")
public class MesocycleResource {

    @Autowired
    MesocycleService mesocycleService;

    @GetMapping
    public ResponseEntity<List<Mesocycle>> findAll(){
        List<Mesocycle> mesocycleList = mesocycleService.findAll();
        return ResponseEntity.ok().body(mesocycleList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mesocycle> findById(@PathVariable Long id) {
        Mesocycle obj = mesocycleService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Mesocycle> insert(@RequestBody Mesocycle mesocycle){
        Mesocycle obj = mesocycleService.insert(mesocycle);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
