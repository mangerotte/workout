package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.model.PhysicalExamination;
import com.example.luizmangerotte.workout.repositories.PhysicalExaminationRepository;
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
public class PhysicalExaminationService {

    @Autowired
    PhysicalExaminationRepository physicalExaminationRepository;

    public List<PhysicalExamination> findAll() {
        try {
            log.info("Returning all physicalExamination");
            return physicalExaminationRepository.findAll();
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'findAll()'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<PhysicalExamination> findById(Long id) {
        try {
            log.info("Returning physicalExamination id " + id);
            return Optional.of(physicalExaminationRepository
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

    public PhysicalExamination insert(PhysicalExamination physicalExamination) {
        try {
            log.info("PhysicalExamination successfully created");
            return physicalExaminationRepository.save(physicalExamination);
        } catch (RuntimeException e) {
            log.error("Unexpected error in method 'insert'");
            throw new RuntimeException(e.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            log.info("PhysicalExamination successfully deleted with id:" + id);
            physicalExaminationRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("PhysicalExamination not found");
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            log.error("Database Violation");
            throw new DataBaseException(e.getMessage());
        }
    }
    public PhysicalExamination update(Long id, PhysicalExamination physicalExaminationUpdate) {
        try {
            log.info("PhysicalExamination successfully update with id:" + id);
            PhysicalExamination physicalExaminationDb = physicalExaminationRepository.getReferenceById(id);
            updateData(physicalExaminationDb, physicalExaminationUpdate);
            return physicalExaminationRepository.save(physicalExaminationDb);
        } catch (EntityNotFoundException e) {
            log.info("PhysicalExamination not found:");
            throw new ResourceNotFoundException(id);
        } catch (RuntimeException e) {
            log.info("Unexpected error in method 'update'");
            throw new RuntimeException(e.getMessage());
        }
    }

    private void updateData(PhysicalExamination physicalExaminationDb, PhysicalExamination physicalExaminationUpdate) {
        physicalExaminationDb.setClient(physicalExaminationUpdate.getClient());
        physicalExaminationDb.setSkinFold(physicalExaminationUpdate.getSkinFold());
        physicalExaminationDb.setEvaluationDate(physicalExaminationUpdate.getEvaluationDate());
        physicalExaminationDb.setHeight(physicalExaminationUpdate.getHeight());
        physicalExaminationDb.setFatPercentage(physicalExaminationUpdate.getFatPercentage());
        physicalExaminationDb.setWeight(physicalExaminationUpdate.getWeight());
    }
}
