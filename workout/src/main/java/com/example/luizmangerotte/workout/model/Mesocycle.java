package com.example.luizmangerotte.workout.model;

import com.example.luizmangerotte.workout.model.enums.PhysicalSkills;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Mesocycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "physical_skill")
    private PhysicalSkills physicalSkill;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @Column(name = "start_date")
    private LocalDate startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_macrocycle")
    private Macrocycle macrocycle;

    @OneToMany(mappedBy = "mesocycle")
    private List<Microcycle> microcyclesList = new ArrayList<>();

    public Mesocycle(Long id, PhysicalSkills physicalSkill, LocalDate startDate, LocalDate endDate, Macrocycle macrocycle) {
        this.id = id;
        this.physicalSkill = physicalSkill;
        this.startDate = startDate;
        this.endDate = endDate;
        this.macrocycle = macrocycle;
    }
}
