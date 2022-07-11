package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Avaliacao;
import com.example.luizmangerotte.workout.repositories.AlunoRepository;
import com.example.luizmangerotte.workout.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;

    public List<Avaliacao> findAll(){
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findById(Long id) {
        Optional<Avaliacao> obj = avaliacaoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }
}
