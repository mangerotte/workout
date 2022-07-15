package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.PhysicalExamination;
import com.example.luizmangerotte.workout.services.impl.PhysicalExaminationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/physical-examination")
public class PhysicalExaminationResource {

    @Autowired
    PhysicalExaminationServiceImpl physicalExaminationServiceImpl;

    @GetMapping
    public ResponseEntity<List<PhysicalExamination>> findAll(){
        List<PhysicalExamination> physicalExaminationList = physicalExaminationServiceImpl.findAll();
        return ResponseEntity.ok().body(physicalExaminationList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PhysicalExamination> findById(@PathVariable Long id) {
        PhysicalExamination obj = physicalExaminationServiceImpl.findById(id);
        return ResponseEntity.ok().body(obj);}
    @PostMapping
    public ResponseEntity<PhysicalExamination> insert(@RequestBody PhysicalExamination physicalExamination){
        PhysicalExamination obj = physicalExaminationServiceImpl.insert(physicalExamination);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
