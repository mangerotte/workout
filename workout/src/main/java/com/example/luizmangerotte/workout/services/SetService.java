package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.entities.SetExercise;
import com.example.luizmangerotte.workout.repositories.SetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetService {

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
