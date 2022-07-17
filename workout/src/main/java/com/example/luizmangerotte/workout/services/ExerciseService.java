package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.Exercise;
import com.example.luizmangerotte.workout.repositories.ExerciseRepository;
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
public class ExerciseService {


    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> findAll(){
        try {
            return exerciseRepository.findAll();
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<Exercise> findById(Long id) {
        try {
            log.info("Returning exercise id " + id);
            return Optional.of(exerciseRepository
                            .findById(id)
                            .get());
        } catch (ResourceNotFoundException e){
            log.error("Not found id: " + id);
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'findById'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public Exercise insert(Exercise exercise){
        try {
            log.info("Exercise successfully created");
            return exerciseRepository.save(exercise);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public void delete(Long id) {
        try {
            log.info("Exercise successfully deleted with id:" + id);
            exerciseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            log.error("Exercise not found");
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }
    public Exercise update(Long id, Exercise exercise){
        try {
            log.info("Exercise successfully update with id:" + id);
            Exercise exceriseDb = exerciseRepository.getReferenceById(id);
            updateData(exceriseDb, exercise);
            return exerciseRepository.save(exceriseDb);
        }catch (EntityNotFoundException e){
            log.info("Exercise not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
    private void updateData(Exercise exerciseDb, Exercise exerciseUpdate) {
        exerciseDb.setName(exerciseUpdate.getName());
        exerciseDb.setMuscleGroup(exerciseUpdate.getMuscleGroup());
        exerciseDb.setVideoUrl(exerciseUpdate.getVideoUrl());
    }

}
