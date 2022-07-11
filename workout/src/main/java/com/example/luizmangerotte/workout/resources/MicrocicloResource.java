package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Microciclo;
import com.example.luizmangerotte.workout.services.MicrocicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
