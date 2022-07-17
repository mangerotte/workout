package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.SetExercise;
import com.example.luizmangerotte.workout.repositories.SetRepository;
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
public class SetExerciseService {

    @Autowired
    SetRepository setRepository;

    public List<SetExercise> findAll() {
        try {
            log.info("Returning all set");
            return setRepository.findAll();
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<SetExercise> findById(Long id) {
        try {
            log.info("Returning set id " + id);
            return Optional.of(setRepository
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

    public SetExercise insert(SetExercise set) {
        try {
            log.info("SetExercise successfully created");
            return setRepository.save(set);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            log.info("SetExercise successfully deleted with id:" + id);
            setRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("SetExercise not found");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }

    public SetExercise update(Long id, SetExercise setUpdate) {
        try {
            log.info("SetExercise successfully update with id:" + id);
            SetExercise setDb = setRepository.getReferenceById(id);
            updateData(setDb, setUpdate);
            return setRepository.save(setDb);
        } catch (EntityNotFoundException e) {
            log.info("SetExercise not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }

    private void updateData(SetExercise setDb, SetExercise setUpdate) {
        setDb.setRepetition(setUpdate.getRepetition());
        setDb.setTrainingSessionExercise(setUpdate.getTrainingSessionExercise());
        setDb.setWeight(setUpdate.getWeight());
    }
}
