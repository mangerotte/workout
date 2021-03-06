package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.Mesocycle;
import com.example.luizmangerotte.workout.repositories.MesocycleRepository;
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
public class MesocycleService {

    @Autowired
    MesocycleRepository mesocycleRepository;

    public List<Mesocycle> findAll(){
        try {
            log.info("Returning all mesocycle");
            return mesocycleRepository.findAll();
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public Optional<Mesocycle> findById(Long id) {
        try {
            log.info("Returning mesocycle id " + id);
            return Optional.of(mesocycleRepository
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
    public Mesocycle insert (Mesocycle mesocycle) {
        try {
            log.info("Mesocycle successfully created");
            return mesocycleRepository.save(mesocycle);
        } catch (RuntimeException e){
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }
    public void delete(Long id) {
        try {
            log.info("Mesocycle successfully deleted with id:" + id);
            mesocycleRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("Mesocycle not found");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }
    public Mesocycle update(Long id, Mesocycle mesocycleUpdate){
        try {
            log.info("Mesocycle successfully update with id:" + id);
            Mesocycle mesocycleDb = mesocycleRepository.getReferenceById(id);
            updateData(mesocycleDb, mesocycleUpdate);
            return mesocycleRepository.save(mesocycleDb);
        }catch (EntityNotFoundException e){
            log.info("Mesocycle not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }
    private void updateData(Mesocycle mesocycleDb, Mesocycle mesocycleUpdate) {
        mesocycleDb.setStartDate(mesocycleUpdate.getStartDate());
        mesocycleDb.setEndDate(mesocycleUpdate.getEndDate());
        mesocycleDb.setMacrocycle(mesocycleUpdate.getMacrocycle());
        mesocycleDb.setPhysicalSkill(mesocycleUpdate.getPhysicalSkill());
    }
}

