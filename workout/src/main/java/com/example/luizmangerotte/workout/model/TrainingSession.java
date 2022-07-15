package com.example.luizmangerotte.workout.model;


import com.example.luizmangerotte.workout.model.enums.MuscleGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Data
@NoArgsConstructor
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

    public TrainingSession(Long id, LocalDate sessionDay, String name, Microcycle microcycle) {
        this.id = id;
        this.sessionDay = sessionDay;
        this.name = name;
        this.microcycle = microcycle;
    }

    public Double getVolumeLoadSession() {
        return trainingSessionExerciseList
                .stream()
                .map(TrainingSessionExercise::getVolumeLoadExercise)
                .reduce(0.0, Double::sum);
    }
    public Integer getTotalSetSession(MuscleGroup muscleGroup) {
       return trainingSessionExerciseList.stream()
               .filter(sessionExercise-> sessionExercise.getExercise().getMuscleGroup() == muscleGroup)
               .map(TrainingSessionExercise::getSetNumber)
               .reduce(0,Integer::sum);
    }
}
