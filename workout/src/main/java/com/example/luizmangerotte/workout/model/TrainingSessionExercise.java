package com.example.luizmangerotte.workout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class TrainingSessionExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "zone_rep")
    private String zoneRep;
    private Double rest;
    private String cadence;
    @Column(name = "set_number")
    private Integer setNumber;

    @ManyToOne
    @JoinColumn(name = "id_exercise")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name = "id_training_session")
    @JsonIgnore
    private TrainingSession trainingSession;

    @OneToMany(mappedBy = "trainingSessionExercise")
    private List<SetExercise> setExerciseList = new ArrayList<>();

    public TrainingSessionExercise(Long id, String zoneRep, Double rest, String cadence, Integer setNumber, Exercise exercise, TrainingSession trainingSession) {
        this.id = id;
        this.zoneRep = zoneRep;
        this.rest = rest;
        this.cadence = cadence;
        this.setNumber = setNumber;
        this.exercise = exercise;
        this.trainingSession = trainingSession;
    }

    public Double getVolumeLoadExercise(){
       return setExerciseList.stream()
               .map(SetExercise::getVolumeLoadSet)
               .reduce(0.0, Double::sum);
    }
}
