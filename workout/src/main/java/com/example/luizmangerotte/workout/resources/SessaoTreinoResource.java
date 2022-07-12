package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.entities.enums.GrupamentosMusculares;
import com.example.luizmangerotte.workout.services.SessaoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "/{id}/{grupamentosMusculares}")
    public ResponseEntity<Integer> numeroSeriesGrupamento(@PathVariable Long id, @PathVariable GrupamentosMusculares grupamentosMusculares){
        Integer obj = sessaoTreinoService.numeroSeriesGrupamento(id, grupamentosMusculares);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<SessaoTreino> insert(@RequestBody SessaoTreino sessaoTreino){
        SessaoTreino obj = sessaoTreinoService.insert(sessaoTreino);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
