package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.Periodization;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Macrocycle {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String goal;
        @Column(name = "type_periodization")
        private Integer typePeriodization;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
        @Column(name = "start_date")
        private LocalDate startDate;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
        @Column(name = "end_date")
        private LocalDate endDate;

        @ManyToOne
        @JoinColumn(name = "client_id")
        private Client client;

        @OneToMany(mappedBy = "macrocycle")
        List<Mesocycle> mesocycleList = new ArrayList<>();

    public Macrocycle() {
    }

    public Macrocycle(Long id, String goal, Periodization typePeriodization, LocalDate startDate, LocalDate endDate, Client client) {
        this.id = id;
        this.goal = goal;
        setTypePeriodization(typePeriodization);
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public Periodization getTypePeriodization() {
        return Periodization.valueOf(typePeriodization);
    }

    public void setTypePeriodization(Periodization typePeriodization) {
        this.typePeriodization = typePeriodization.getCode();
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Macrocycle)) return false;
        Macrocycle that = (Macrocycle) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
