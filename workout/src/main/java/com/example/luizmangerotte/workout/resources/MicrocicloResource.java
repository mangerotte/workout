package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Microciclo;
import com.example.luizmangerotte.workout.services.MicrocicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/microciclos")
public class MicrocicloResource {

    @Autowired
    MicrocicloService microcicloService;

    @GetMapping
    public ResponseEntity<List<Microciclo>> findAll(){
        List<Microciclo> listMicrociclo = microcicloService.findAll();
        return ResponseEntity.ok().body(listMicrociclo);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Microciclo> findById(@PathVariable Long id) {
        Microciclo obj = microcicloService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Microciclo> insert(@RequestBody Microciclo microciclo){
        Microciclo obj = microcicloService.insert(microciclo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
