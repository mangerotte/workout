package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.PhysicalExamination;
import com.example.luizmangerotte.workout.services.PhysicalExaminationService;
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
    PhysicalExaminationService physicalExaminationService;

    @GetMapping
    public ResponseEntity<List<PhysicalExamination>> findAll(){
        List<PhysicalExamination> physicalExaminationList = physicalExaminationService.findAll();
        return ResponseEntity.ok().body(physicalExaminationList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PhysicalExamination> findById(@PathVariable Long id) {
        PhysicalExamination obj = physicalExaminationService.findById(id);
        return ResponseEntity.ok().body(obj);}
    @PostMapping
    public ResponseEntity<PhysicalExamination> insert(@RequestBody PhysicalExamination physicalExamination){
        PhysicalExamination obj = physicalExaminationService.insert(physicalExamination);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
