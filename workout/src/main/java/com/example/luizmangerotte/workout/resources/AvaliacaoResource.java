package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Avaliacao;
import com.example.luizmangerotte.workout.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/avaliacoes")
public class AvaliacaoResource {

    @Autowired
    AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<List<Avaliacao>> findAll(){
        List<Avaliacao> listAvaliacoes = avaliacaoService.findAll();
        return ResponseEntity.ok().body(listAvaliacoes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Avaliacao> findById(@PathVariable Long id) {
        Avaliacao obj = avaliacaoService.findById(id);
        return ResponseEntity.ok().body(obj);}
    @PostMapping
    public ResponseEntity<Avaliacao> insert(@RequestBody Avaliacao avaliacao){
        Avaliacao obj = avaliacaoService.insert(avaliacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
