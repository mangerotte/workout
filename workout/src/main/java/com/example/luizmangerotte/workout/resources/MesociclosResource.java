package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Macrociclo;
import com.example.luizmangerotte.workout.entities.Mesociclos;
import com.example.luizmangerotte.workout.services.MesociclosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
