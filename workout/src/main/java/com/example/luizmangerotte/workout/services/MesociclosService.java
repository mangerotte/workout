package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Avaliacao;
import com.example.luizmangerotte.workout.entities.Mesociclos;
import com.example.luizmangerotte.workout.repositories.AvaliacaoRepository;
import com.example.luizmangerotte.workout.repositories.MesocicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesociclosService {

    @Autowired
    MesocicloRepository mesocicloRepository;

    public List<Mesociclos> findAll(){
        return mesocicloRepository.findAll();
    }

    public Mesociclos findById(Long id) {
        Optional<Mesociclos> obj = mesocicloRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Mesociclos insert(Mesociclos mesociclos){
        return mesocicloRepository.save(mesociclos);
    }
}
