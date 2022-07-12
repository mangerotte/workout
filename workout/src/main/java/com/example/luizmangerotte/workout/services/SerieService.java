package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Serie;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.repositories.SerieRepository;
import com.example.luizmangerotte.workout.repositories.SessaoTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<Serie> findAll(){
        return serieRepository.findAll();
    }

    public Serie findById(Long id) {
        Optional<Serie> obj = serieRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }
}
