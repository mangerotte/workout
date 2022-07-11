package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Macrociclo;
import com.example.luizmangerotte.workout.services.MacrocicloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
