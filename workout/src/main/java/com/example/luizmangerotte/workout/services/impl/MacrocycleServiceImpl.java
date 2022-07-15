package com.example.luizmangerotte.workout.services.impl;


import com.example.luizmangerotte.workout.model.Macrocycle;
import com.example.luizmangerotte.workout.repositories.MacrocycleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MacrocycleServiceImpl {

    @Autowired
    MacrocycleRepository macrocycleRepository;

    public List<Macrocycle> findAll(){
        return macrocycleRepository.findAll();
    }

    public Macrocycle findById(Long id) {
        Optional<Macrocycle> obj = macrocycleRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Macrocycle insert(Macrocycle macrocycle){
        return macrocycleRepository.save(macrocycle);
    }
}
