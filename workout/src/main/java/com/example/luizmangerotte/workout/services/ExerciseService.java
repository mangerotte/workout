package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.Exercise;
import com.example.luizmangerotte.workout.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> findAll(){
        return exerciseRepository.findAll();
    }

    public Exercise findById(Long id) {
        Optional<Exercise> obj = exerciseRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }
    public Exercise insert(Exercise exercise){
        return exerciseRepository.save(exercise);
    }
}
