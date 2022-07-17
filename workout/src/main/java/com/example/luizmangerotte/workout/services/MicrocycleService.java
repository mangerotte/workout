package com.example.luizmangerotte.workout.services;


import com.example.luizmangerotte.workout.model.Microcycle;
import com.example.luizmangerotte.workout.repositories.MicrocycleRepository;
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
public class MicrocycleService {

    @Autowired
    MicrocycleRepository microcycleRepository;

    public List<Microcycle> findAll() {
        try {
            log.info("Returning all microcycle");
            return microcycleRepository.findAll();
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<Microcycle> findById(Long id) {
        try {
            log.info("Returning microcycle id " + id);
            return Optional.of(microcycleRepository
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

    public Microcycle insert(Microcycle microcycle) {
        try {
            log.info("Microcycle successfully created");
            return microcycleRepository.save(microcycle);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            log.info("Microcycle successfully deleted with id:" + id);
            microcycleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("Microcycle not found");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }

    public Microcycle update(Long id, Microcycle microcycleUpdate) {
        try {
            log.info("Microcycle successfully update with id:" + id);
            Microcycle microcycleDb = microcycleRepository.getReferenceById(id);
            updateData(microcycleDb, microcycleUpdate);
            return microcycleRepository.save(microcycleDb);
        } catch (EntityNotFoundException e) {
            log.info("Microcycle not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }

    private void updateData(Microcycle microcycleDb, Microcycle microcycleUpdate) {
        microcycleDb.setStartDate(microcycleUpdate.getStartDate());
        microcycleDb.setEndDate(microcycleUpdate.getEndDate());
        microcycleDb.setMesocycle(microcycleUpdate.getMesocycle());
        microcycleDb.setTypeMicrocyle(microcycleUpdate.getTypeMicrocyle());
    }

}