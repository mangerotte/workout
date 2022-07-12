package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Exercicio;
import com.example.luizmangerotte.workout.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/exercicios")
public class ExercicioResource {

    @Autowired
    ExercicioService exercicioService;

    @GetMapping
    public ResponseEntity<List<Exercicio>> findAll(){
        List<Exercicio> listExercicios = exercicioService.findAll();
        return ResponseEntity.ok().body(listExercicios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Exercicio> findById(@PathVariable Long id) {
        Exercicio obj = exercicioService.findById(id);
        return ResponseEntity.ok().body(obj);}

    @PostMapping
    public ResponseEntity<Exercicio> insert(@RequestBody Exercicio exercicio){
        Exercicio obj = exercicioService.insert(exercicio);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}


