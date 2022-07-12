package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Aluno;
import com.example.luizmangerotte.workout.entities.Mesociclos;
import com.example.luizmangerotte.workout.entities.Microciclo;
import com.example.luizmangerotte.workout.repositories.MesocicloRepository;
import com.example.luizmangerotte.workout.repositories.MicrocicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicrocicloService {

    @Autowired
    MicrocicloRepository microcicloRepository;

    public List<Microciclo> findAll(){
        return microcicloRepository.findAll();
    }

    public Microciclo findById(Long id) {
        Optional<Microciclo> obj = microcicloRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Microciclo insert(Microciclo microciclo){
        return microcicloRepository.save(microciclo);
    }
}
