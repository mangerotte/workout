package com.example.luizmangerotte.workout.model;

import com.example.luizmangerotte.workout.model.enums.Periodization;
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
public class Macrocycle {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String goal;
        @Column(name = "type_periodization")
        private Periodization typePeriodization;
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
        @JsonIgnore
        List<Mesocycle> mesocycleList = new ArrayList<>();

        public Macrocycle(Long id, String goal, Periodization typePeriodization, LocalDate startDate, LocalDate endDate, Client client) {
                this.id = id;
                this.goal = goal;
                this.typePeriodization = typePeriodization;
                this.startDate = startDate;
                this.endDate = endDate;
                this.client = client;
        }
}
