package com.example.luizmangerotte.workout.services.impl;


import com.example.luizmangerotte.workout.model.Microcycle;
import com.example.luizmangerotte.workout.repositories.MicrocycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicrocycleServiceImpl {

    @Autowired
    MicrocycleRepository microcycleRepository;

    public List<Microcycle> findAll(){
        return microcycleRepository.findAll();
    }

    public Microcycle findById(Long id) {
        Optional<Microcycle> obj = microcycleRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Microcycle insert(Microcycle microcycle){
        return microcycleRepository.save(microcycle);
    }
}
