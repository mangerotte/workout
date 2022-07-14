package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.entities.TrainingSessionExercise;
import com.example.luizmangerotte.workout.repositories.TrainingSessionExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingSessionExerciseService {

    @Autowired
    TrainingSessionExerciseRepository trainingSessionExerciseRepository;

    public List<TrainingSessionExercise> findAll(){
        return trainingSessionExerciseRepository.findAll();
    }

    public TrainingSessionExercise findById(Long id) {
        Optional<TrainingSessionExercise> obj = trainingSessionExerciseRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public TrainingSessionExercise insert(TrainingSessionExercise trainingSessionExercise){
        return trainingSessionExerciseRepository.save(trainingSessionExercise);
    }
}
