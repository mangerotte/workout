package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Mesociclos;
import com.example.luizmangerotte.workout.services.MesociclosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/mesociclos")
public class MesociclosResource {

    @Autowired
    MesociclosService mesociclosService;

    @GetMapping
    public ResponseEntity<List<Mesociclos>> findAll(){
        List<Mesociclos> listMesociclos = mesociclosService.findAll();
        return ResponseEntity.ok().body(listMesociclos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mesociclos> findById(@PathVariable Long id) {
        Mesociclos obj = mesociclosService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Mesociclos> insert(@RequestBody Mesociclos mesociclos){
        Mesociclos obj = mesociclosService.insert(mesociclos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
