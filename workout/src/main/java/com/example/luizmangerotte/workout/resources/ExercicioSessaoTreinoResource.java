package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.ExercicioSessaoTreino;
import com.example.luizmangerotte.workout.services.ExercicioSessaoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ex-sessao-treino")
public class ExercicioSessaoTreinoResource {

    @Autowired
    ExercicioSessaoTreinoService exercicioSessaoTreinoService;

    @GetMapping
    public ResponseEntity<List<ExercicioSessaoTreino>> findAll(){
        List<ExercicioSessaoTreino> listSessaoTreino = exercicioSessaoTreinoService.findAll();
        return ResponseEntity.ok().body(listSessaoTreino);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExercicioSessaoTreino> findById(@PathVariable Long id) {
        ExercicioSessaoTreino obj = exercicioSessaoTreinoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<ExercicioSessaoTreino> insert(@RequestBody ExercicioSessaoTreino exercicioSessaoTreino){
        ExercicioSessaoTreino obj = exercicioSessaoTreinoService.insert(exercicioSessaoTreino);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
