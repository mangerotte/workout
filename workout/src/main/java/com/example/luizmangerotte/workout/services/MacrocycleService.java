package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.Macrocycle;
import com.example.luizmangerotte.workout.repositories.MacrocycleRepository;
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
public class MacrocycleService {

    @Autowired
    MacrocycleRepository macrocycleRepository;

    public List<Macrocycle> findAll() {
        try {
            log.info("Returning all macrocycle");
            return macrocycleRepository.findAll();
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }
        public Optional<Macrocycle> findById(Long id) {
            try {
                log.info("Returning macrocycle id " + id);
                return Optional.of(macrocycleRepository
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
        public Macrocycle insert (Macrocycle macrocycle) {
            try {
                log.info("Macrocycle successfully created");
                return macrocycleRepository.save(macrocycle);
            } catch (RuntimeException e){
                log.error("Unexpected error in method 'insert'");
                throw new RuntimeException(e.getMessage());
            }
        }
    public void delete(Long id) {
        try {
            log.info("Macrocycle successfully deleted with id:" + id);
            macrocycleRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e) {
            log.error("Macrocycle not found");
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }
    public Macrocycle update(Long id, Macrocycle macrocycle){
        try {
            log.info("Macrocycle successfully update with id:" + id);
            Macrocycle macroDb = macrocycleRepository.getReferenceById(id);
            updateData(macroDb, macrocycle);
            return macrocycleRepository.save(macroDb);
        }catch (EntityNotFoundException e){
            log.info("Macrocycle not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
    private void updateData(Macrocycle macroDb, Macrocycle macroUpdate) {
        macroDb.setClient(macroUpdate.getClient());
        macroDb.setStartDate(macroUpdate.getStartDate());
        macroDb.setEndDate(macroUpdate.getEndDate());
        macroDb.setGoal(macroUpdate.getGoal());
        macroDb.setTypePeriodization(macroUpdate.getTypePeriodization());
    }
    }
