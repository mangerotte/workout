package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.TypeMicrocycle;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Microcycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_microcycle")
    private Integer typeMicrocyle;

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

    public Microcycle() {
    }

    public Microcycle(Long id, TypeMicrocycle typeMicrocycle, LocalDate startDate, LocalDate endDate, Mesocycle mesocycle) {
        this.id = id;
        setTypeMicrocycle(typeMicrocycle);
        this.startDate = startDate;
        this.endDate = endDate;
        this.mesocycle = mesocycle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeMicrocycle getTypeMicrocycle() {
        return TypeMicrocycle.valueOf(typeMicrocyle);
    }

    public void setTypeMicrocycle(TypeMicrocycle typeMicrocycle) {
        this.typeMicrocyle = typeMicrocycle.getCode();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Mesocycle getMesocycle() {
        return mesocycle;
    }

    public void setMesocycle(Mesocycle mesocycle) {
        this.mesocycle = mesocycle;
    }

    public List<TrainingSession> getTrainingSessionList() {
        return trainingSessionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Microcycle)) return false;
        Microcycle that = (Microcycle) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}