package com.example.luizmangerotte.workout.services;


import com.example.luizmangerotte.workout.model.Mesocycle;
import com.example.luizmangerotte.workout.repositories.MesocycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesocycleService {

    @Autowired
    MesocycleRepository mesocycleRepository;

    public List<Mesocycle> findAll(){
        return mesocycleRepository.findAll();
    }

    public Mesocycle findById(Long id) {
        Optional<Mesocycle> obj = mesocycleRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Mesocycle insert(Mesocycle mesocycle){
        return mesocycleRepository.save(mesocycle);
    }
}
