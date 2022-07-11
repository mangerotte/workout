package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Avaliacao;
import com.example.luizmangerotte.workout.entities.Exercicio;
import com.example.luizmangerotte.workout.services.AvaliacaoService;
import com.example.luizmangerotte.workout.services.ExercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}


