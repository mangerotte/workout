package com.example.luizmangerotte.workout.model;


import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @Column(name = "session_day")
    private LocalDate sessionDay;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_microcycle")
    @JsonIgnore
    private Microcycle microcycle;

    @OneToMany(mappedBy = "trainingSession")
    List<TrainingSessionExercise> trainingSessionExerciseList = new ArrayList<>();


    public TrainingSession() {
    }

    public TrainingSession(Long id, LocalDate sessionDay, String name, Microcycle microcycle) {
        this.id = id;
        this.sessionDay = sessionDay;
        this.name = name;
        this.microcycle = microcycle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSessionDay() {
        return sessionDay;
    }

    public void setSessionDay(LocalDate sessionDay) {
        this.sessionDay = sessionDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Microcycle getMicrocycle() {
        return microcycle;
    }

    public void setMicrocycle(Microcycle microcycle) {
        this.microcycle = microcycle;
    }

    public List<TrainingSessionExercise> getTrainingSessionExerciseList() {
        return trainingSessionExerciseList;
    }

    public Double getVolumeLoadSession(){
        Double sum = 0.0;
        for (TrainingSessionExercise volume : trainingSessionExerciseList){
            sum += volume.getVolumeLoadExercise();
        }
        return sum;
    }

    public Integer getTotalSetSession(MuscleGroup muscleGroup){
        Integer sum = 0;
        for (TrainingSessionExercise exercise : trainingSessionExerciseList){
            if (exercise.getExercise().getMuscleGroup() == muscleGroup){
                sum += exercise.getSetNumber();
            }
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainingSession)) return false;
        TrainingSession that = (TrainingSession) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
