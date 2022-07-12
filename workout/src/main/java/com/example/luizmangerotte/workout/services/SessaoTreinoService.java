package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Microciclo;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.entities.enums.GrupamentosMusculares;
import com.example.luizmangerotte.workout.repositories.MicrocicloRepository;
import com.example.luizmangerotte.workout.repositories.SessaoTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SessaoTreinoService {

    @Autowired
    SessaoTreinoRepository sessaoTreinoRepository;

    public List<SessaoTreino> findAll(){
        return sessaoTreinoRepository.findAll();
    }

    public SessaoTreino findById(Long id) {
        Optional<SessaoTreino> obj = sessaoTreinoRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Integer numeroSeriesGrupamento(Long id, GrupamentosMusculares grupamentosMusculares){
        return sessaoTreinoRepository.findById(id).get().getNumeroSeriesTotais(grupamentosMusculares);
    }

    public SessaoTreino insert(SessaoTreino sessaoTreino){
        return sessaoTreinoRepository.save(sessaoTreino);
    }
}
