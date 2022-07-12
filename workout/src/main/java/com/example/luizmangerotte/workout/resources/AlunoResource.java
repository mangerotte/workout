package com.example.luizmangerotte.workout.resources;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Macrociclo;
import com.example.luizmangerotte.workout.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        List<Aluno> listAlunos = alunoService.findAll();
        return ResponseEntity.ok().body(listAlunos);
    }

    @GetMapping
    @RequestMapping(value="/alunos-ativos")
    public ResponseEntity<List<Aluno>> findActive() {
        List<Aluno> listAtivos = alunoService.findAlunosActive();
        return ResponseEntity.ok().body(listAtivos);
    }

    @GetMapping
    @RequestMapping(value="/numero-alunos-ativos")
    public ResponseEntity<Integer> numberActive() {
        Integer numeroAlunosAtivos = alunoService.numberAlunosActive();
        return ResponseEntity.ok().body(numeroAlunosAtivos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id) {
        Aluno obj = alunoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}