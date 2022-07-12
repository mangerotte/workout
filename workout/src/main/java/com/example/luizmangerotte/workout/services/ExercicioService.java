package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Exercicio;
import com.example.luizmangerotte.workout.repositories.ExercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioService {

    @Autowired
    ExercicioRepository exercicioRepository;

    public List<Exercicio> findAll(){
        return exercicioRepository.findAll();
    }

    public Exercicio findById(Long id) {
        Optional<Exercicio> obj = exercicioRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }
    public Exercicio insert(Exercicio exercicio){
        return exercicioRepository.save(exercicio);
    }
}
