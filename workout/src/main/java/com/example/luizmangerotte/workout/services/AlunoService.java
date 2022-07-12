package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno findById(Long id) {
        Optional<Aluno> obj = alunoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public List<Aluno> findAlunosActive() {
        return alunoRepository.findAll().stream().filter(x -> x.isStatus()).collect(Collectors.toList());
    }

    public Integer numberAlunosActive() {
        List<Aluno> listAtivos = alunoRepository.findAll().stream().filter(x -> x.isStatus()).collect(Collectors.toList());
        return listAtivos.size();
    }

    public Aluno insert(Aluno aluno){
        return alunoRepository.save(aluno);
    }

}
