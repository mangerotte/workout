package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.ExercicioSessaoTreino;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.services.ExercicioSessaoTreinoService;
import com.example.luizmangerotte.workout.services.SessaoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/ex-sessao-treino")
public class ExercicioSessaoTreinoResource {

    @Autowired
    ExercicioSessaoTreinoService exercicioSessaoTreino;

    @GetMapping
    public ResponseEntity<List<ExercicioSessaoTreino>> findAll(){
        List<ExercicioSessaoTreino> listSessaoTreino = exercicioSessaoTreino.findAll();
        return ResponseEntity.ok().body(listSessaoTreino);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExercicioSessaoTreino> findById(@PathVariable Long id) {
        ExercicioSessaoTreino obj = exercicioSessaoTreino.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
