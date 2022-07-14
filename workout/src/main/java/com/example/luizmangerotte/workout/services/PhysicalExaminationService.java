package com.example.luizmangerotte.workout.services;
import com.example.luizmangerotte.workout.entities.PhysicalExamination;
import com.example.luizmangerotte.workout.repositories.PhysicalExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhysicalExaminationService {

    @Autowired
    PhysicalExaminationRepository physicalExaminationRepository;

    public List<PhysicalExamination> findAll(){
        return physicalExaminationRepository.findAll();
    }

    public PhysicalExamination findById(Long id) {
        Optional<PhysicalExamination> obj = physicalExaminationRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException());
    }

    public PhysicalExamination insert(PhysicalExamination physicalExamination){
        return physicalExaminationRepository.save(physicalExamination);
    }
}