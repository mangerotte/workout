package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.TrainingSessionExercise;
import com.example.luizmangerotte.workout.repositories.TrainingSessionExerciseRepository;
import com.example.luizmangerotte.workout.services.exceptions.DataBaseException;
import com.example.luizmangerotte.workout.services.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TrainingSessionExerciseService {

    @Autowired
    TrainingSessionExerciseRepository trainingSessionExerciseRepository;

    public List<TrainingSessionExercise> findAll() {
        try {
            log.info("Returning all trainingSessionExercise");
            return trainingSessionExerciseRepository.findAll();
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<TrainingSessionExercise> findById(Long id) {
        try {
            log.info("Returning trainingSessionExercise id " + id);
            return Optional.of(trainingSessionExerciseRepository
                    .findById(id)
                    .get());
        } catch (ResourceNotFoundException e) {
            log.error("Not found id: " + id);
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findById'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public TrainingSessionExercise insert(TrainingSessionExercise trainingSessionExercise) {
        try {
            log.info("TrainingSessionExercise successfully created");
            return trainingSessionExerciseRepository.save(trainingSessionExercise);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            log.info("TrainingSessionExercise successfully deleted with id:" + id);
            trainingSessionExerciseRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("TrainingSessionExercise not found");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }

    public TrainingSessionExercise update(Long id, TrainingSessionExercise trainingSessionExerciseUpdate) {
        try {
            log.info("TrainingSessionExercise successfully update with id:" + id);
            TrainingSessionExercise trainingSessionExerciseDb =
                    trainingSessionExerciseRepository.getReferenceById(id);
            updateData(trainingSessionExerciseDb, trainingSessionExerciseUpdate);
            return trainingSessionExerciseRepository.save(trainingSessionExerciseDb);
        } catch (EntityNotFoundException e) {
            log.info("TrainingSessionExercise not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }

    private void updateData(TrainingSessionExercise trainingSessionExerciseDb, TrainingSessionExercise trainingSessionExerciseUpdate) {
        trainingSessionExerciseDb.setExercise(trainingSessionExerciseUpdate.getExercise());
        trainingSessionExerciseDb.setTrainingSession(trainingSessionExerciseUpdate.getTrainingSession());
        trainingSessionExerciseDb.setCadence(trainingSessionExerciseUpdate.getCadence());
        trainingSessionExerciseDb.setRest(trainingSessionExerciseUpdate.getRest());
        trainingSessionExerciseDb.setSetNumber(trainingSessionExerciseUpdate.getSetNumber());
        trainingSessionExerciseDb.setZoneRep(trainingSessionExerciseUpdate.getZoneRep());
    }
}
