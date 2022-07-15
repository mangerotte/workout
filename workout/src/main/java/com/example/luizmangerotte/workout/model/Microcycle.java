package com.example.luizmangerotte.workout.model;

import com.example.luizmangerotte.workout.model.enums.TypeMicrocycle;
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
public class Microcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_microcycle")
    private TypeMicrocycle typeMicrocyle;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @Column(name = "start_date")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_mesocycle")
    private Mesocycle mesocycle;

    @OneToMany(mappedBy = "microcycle")
    @JsonIgnore
    private List<TrainingSession> trainingSessionList = new ArrayList<>();

    public Microcycle(Long id, TypeMicrocycle typeMicrocyle, LocalDate startDate, LocalDate endDate, Mesocycle mesocycle) {
        this.id = id;
        this.typeMicrocyle = typeMicrocyle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mesocycle = mesocycle;
    }
}