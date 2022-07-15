package com.example.luizmangerotte.workout.model;

import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
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
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @Column(name = "muscle_group")
    private MuscleGroup muscleGroup;
    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany(mappedBy = "exercise")
    @JsonIgnore

    private List<TrainingSessionExercise> trainingSessionExercise = new ArrayList<>();

    public Exercise(Long id, String name, MuscleGroup muscleGroup, String videoUrl) {
        Id = id;
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.videoUrl = videoUrl;
    }
}
