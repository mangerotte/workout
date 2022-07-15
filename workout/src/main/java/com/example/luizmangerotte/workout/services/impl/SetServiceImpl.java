package com.example.luizmangerotte.workout.services.impl;
import com.example.luizmangerotte.workout.model.SetExercise;
import com.example.luizmangerotte.workout.repositories.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetServiceImpl {

    @Autowired
    SetRepository setRepository;

    public List<SetExercise> findAll(){
        return setRepository.findAll();
    }

    public SetExercise findById(Long id) {
        Optional<SetExercise> obj = setRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public SetExercise insert(SetExercise setExercise){
        return setRepository.save(setExercise);
    }
}
