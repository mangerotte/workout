package com.example.luizmangerotte.workout.services;

import com.example.luizmangerotte.workout.entities.Macrociclo;
import com.example.luizmangerotte.workout.repositories.MacrocicloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MacrocicloService {

    @Autowired
    MacrocicloRepository macrocicloRepository;

    public List<Macrociclo> findAll(){
        return macrocicloRepository.findAll();
    }

    public Macrociclo findById(Long id) {
        Optional<Macrociclo> obj = macrocicloRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }
}
