package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Macrociclo;
import com.example.luizmangerotte.workout.services.MacrocicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/macrociclos")
public class MacrocicloResource {

    @Autowired
    MacrocicloService macrocicloService;

    @GetMapping
    public ResponseEntity<List<Macrociclo>> findAll(){
        List<Macrociclo> listMacrociclos = macrocicloService.findAll();
        return ResponseEntity.ok().body(listMacrociclos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Macrociclo> findById(@PathVariable Long id) {
        Macrociclo obj = macrocicloService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Macrociclo> insert(@RequestBody Macrociclo macrociclo){
        Macrociclo obj = macrocicloService.insert(macrociclo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
