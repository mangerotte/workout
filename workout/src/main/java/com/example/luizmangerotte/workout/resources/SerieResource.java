package com.example.luizmangerotte.workout.resources;
import com.example.luizmangerotte.workout.entities.Serie;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.example.luizmangerotte.workout.services.SerieService;
import com.example.luizmangerotte.workout.services.SessaoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/series")
public class SerieResource {

    @Autowired
    SerieService serieService;

    @GetMapping
    public ResponseEntity<List<Serie>> findAll(){
        List<Serie> listSeries= serieService.findAll();
        return ResponseEntity.ok().body(listSeries);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Serie> findById(@PathVariable Long id) {
        Serie obj = serieService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
