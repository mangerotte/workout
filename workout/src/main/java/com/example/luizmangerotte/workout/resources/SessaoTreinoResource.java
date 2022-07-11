package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.services.SessaoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sessao-treino")
public class SessaoTreinoResource {

    @Autowired
    SessaoTreinoService sessaoTreinoService;

    @GetMapping
    public ResponseEntity<List<SessaoTreino>> findAll(){
        List<SessaoTreino> listSessaoTreino = sessaoTreinoService.findAll();
        return ResponseEntity.ok().body(listSessaoTreino);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SessaoTreino> findById(@PathVariable Long id) {
        SessaoTreino obj = sessaoTreinoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
