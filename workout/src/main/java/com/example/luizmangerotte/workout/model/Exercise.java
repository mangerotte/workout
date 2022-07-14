package com.example.luizmangerotte.workout.model;

import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    @Column(name = "muscle_group")
    private Integer muscleGroup;
    @Column(name = "video_url")
    private String videoUrl;

    @OneToMany(mappedBy = "exercise")
    @JsonIgnore
    private List<TrainingSessionExercise> trainingSessionExercise = new ArrayList<>();

    public Exercise() {
    }

    public Exercise(Long id, String name, MuscleGroup muscleGroup, String videoUrl) {
        Id = id;
        this.name = name;
        setMuscleGroup(muscleGroup);
        this.videoUrl = videoUrl;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MuscleGroup getMuscleGroup() {
        return MuscleGroup.valueOf(muscleGroup);
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup= muscleGroup.getCode();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercise)) return false;
        Exercise exercise = (Exercise) o;
        return Objects.equals(getId(), exercise.getId()) && Objects.equals(getName(), exercise.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
