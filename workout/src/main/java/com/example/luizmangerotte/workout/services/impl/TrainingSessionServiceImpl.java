package com.example.luizmangerotte.workout.services.impl;
import com.example.luizmangerotte.workout.model.TrainingSession;
import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.example.luizmangerotte.workout.repositories.TrainingSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingSessionServiceImpl {

    @Autowired
    TrainingSessionRepository trainingSessionRepository;

    public List<TrainingSession> findAll(){
        return trainingSessionRepository.findAll();
    }

    public TrainingSession findById(Long id) {
        Optional<TrainingSession> obj = trainingSessionRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public Integer getSetGroup(Long id, MuscleGroup muscleGroup){
        return trainingSessionRepository.findById(id).get().getTotalSetSession(muscleGroup);
    }

    public TrainingSession insert(TrainingSession trainingSession){
        return trainingSessionRepository.save(trainingSession);
    }
}
