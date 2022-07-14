package com.example.luizmangerotte.workout.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class SetExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double weight;
    private Integer repetition;

    @ManyToOne
    @JoinColumn(name = "id_session_exercise")
    @JsonIgnore
    private TrainingSessionExercise trainingSessionExercise;

    public SetExercise() {
    }

    public SetExercise(Long id, Double weight, Integer repetition, TrainingSessionExercise trainingSessionExercise) {
        this.id = id;
        this.weight = weight;
        this.repetition = repetition;
        this.trainingSessionExercise = trainingSessionExercise;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getRepetition() {
        return repetition;
    }

    public void setRepetition(Integer repetition) {
        this.repetition = repetition;
    }

    public TrainingSessionExercise getTrainingSessionExercise() {
        return trainingSessionExercise;
    }

    public Double getVolumeLoadSet(){
        return repetition * weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetExercise)) return false;
        SetExercise setExercise = (SetExercise) o;
        return Objects.equals(getId(), setExercise.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
