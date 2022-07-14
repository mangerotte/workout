package com.example.luizmangerotte.workout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
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

    public TrainingSessionExercise() {
    }

    public TrainingSessionExercise(Long id, String zoneRep, Double rest, String cadence, Integer setNumber, Exercise exercise, TrainingSession trainingSession) {
        this.id = id;
        this.zoneRep = zoneRep;
        this.rest = rest;
        this.cadence = cadence;
        this.setNumber = setNumber;
        this.exercise = exercise;
        this.trainingSession = trainingSession;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZoneRep() {
        return zoneRep;
    }

    public void setZoneRep(String zoneRep) {
        this.zoneRep = zoneRep;
    }

    public Double getRest() {
        return rest;
    }

    public void setRest(Double rest) {
        this.rest = rest;
    }

    public String getCadence() {
        return cadence;
    }

    public void setCadence(String cadence) {
        this.cadence = cadence;
    }

    public Integer getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(Integer setNumber) {
        this.setNumber = setNumber;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public TrainingSession getTrainingSession() {
        return trainingSession;
    }

    public void setTrainingSession(TrainingSession trainingSession) {
        this.trainingSession = trainingSession;
    }

    public List<SetExercise> getSetList() {
        return setExerciseList;
    }

    public Double getVolumeLoadExercise(){
       Double sum = 0.0;
       for (SetExercise volume : setExerciseList){
           sum += volume.getVolumeLoadSet();
       }
       return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainingSessionExercise)) return false;
        TrainingSessionExercise that = (TrainingSessionExercise) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
