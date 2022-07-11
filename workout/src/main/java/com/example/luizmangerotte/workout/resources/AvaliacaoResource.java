package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Avaliacao;
import com.example.luizmangerotte.workout.services.AlunoService;
import com.example.luizmangerotte.workout.services.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
