package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.TrainingSession;
import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.example.luizmangerotte.workout.repositories.TrainingSessionRepository;
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
public class TrainingSessionService {

    @Autowired
    TrainingSessionRepository trainingSessionRepository;

    public List<TrainingSession> findAll() {
        try {
            log.info("Returning all trainingSession");
            return trainingSessionRepository.findAll();
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public Optional<TrainingSession> findById(Long id) {
        try {
            log.info("Returning trainingSession id " + id);
            return Optional.of(trainingSessionRepository
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
    public TrainingSession insert(TrainingSession trainingSession) {
        try {
            log.info("TrainingSession successfully created");
            return trainingSessionRepository.save(trainingSession);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public void delete(Long id) {
        try {
            log.info("TrainingSession successfully deleted with id:" + id);
            trainingSessionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("TrainingSession not found");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }
    public TrainingSession update(Long id, TrainingSession trainingSessionUpdate) {
        try {
            log.info("TrainingSession successfully update with id:" + id);
            TrainingSession trainingSessionDb = trainingSessionRepository.getReferenceById(id);
            updateData(trainingSessionDb, trainingSessionUpdate);
            return trainingSessionRepository.save(trainingSessionDb);
        } catch (EntityNotFoundException e) {
            log.info("TrainingSession not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
    private void updateData(TrainingSession trainingSessionDb, TrainingSession trainingSessionUpdate) {
        trainingSessionDb.setSessionDay(trainingSessionUpdate.getSessionDay());
        trainingSessionDb.setMicrocycle(trainingSessionUpdate.getMicrocycle());
        trainingSessionDb.setName(trainingSessionUpdate.getName());
    }
    public Optional<Integer> getSetGroup(Long id, MuscleGroup muscleGroup){
        try {
            log.info("Returning the number of series of the requested grouping");
            return trainingSessionRepository.findById(id).map(trainingSession -> trainingSession.getTotalSetSession(muscleGroup));
        } catch (ResourceNotFoundException e) {
            log.info("TrainingSession not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public Optional<Double> getVolumeLoad(Long id){
        try {
            log.info("Returning the id volume load");
            return trainingSessionRepository.findById(id).map(TrainingSession::getVolumeLoadSession);
        } catch (ResourceNotFoundException e) {
            log.info("TrainingSession not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
}
