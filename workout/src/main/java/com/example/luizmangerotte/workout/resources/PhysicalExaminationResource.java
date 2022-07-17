package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.model.PhysicalExamination;
import com.example.luizmangerotte.workout.model.PhysicalExamination;
import com.example.luizmangerotte.workout.services.PhysicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/physical-examination")
public class PhysicalExaminationResource {

    @Autowired
    PhysicalExaminationService physicalExaminationService;

    @GetMapping
    public ResponseEntity<List<PhysicalExamination>> findAll(){
        return ResponseEntity.ok().body(physicalExaminationService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<PhysicalExamination>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(physicalExaminationService.findById(id));}
    @PostMapping
    public ResponseEntity<PhysicalExamination> insert(@RequestBody PhysicalExamination physicalExamination){
        return new ResponseEntity<>(physicalExaminationService.insert(physicalExamination), HttpStatus.CREATED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        physicalExaminationService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<PhysicalExamination> update(@PathVariable Long id, @RequestBody PhysicalExamination physicalExamination){
        return ResponseEntity.ok().body(physicalExamination = physicalExaminationService.update(id, physicalExamination));
    }
}
