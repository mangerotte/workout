package com.example.luizmangerotte.workout.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public Double getVolumeLoadSet(){
        return weight * repetition;
    }
}
