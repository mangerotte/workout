package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.ExercicioSessaoTreino;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.repositories.ExercicioSessaoTreinoRepository;
import com.example.luizmangerotte.workout.repositories.SessaoTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExercicioSessaoTreinoService {

    @Autowired
    ExercicioSessaoTreinoRepository exercicioSessaoTreinoRepository;

    public List<ExercicioSessaoTreino> findAll(){
        return exercicioSessaoTreinoRepository.findAll();
    }

    public ExercicioSessaoTreino findById(Long id) {
        Optional<ExercicioSessaoTreino> obj = exercicioSessaoTreinoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }
}