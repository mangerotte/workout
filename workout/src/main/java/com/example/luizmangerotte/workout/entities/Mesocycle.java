package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.PhysicalSkills;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Mesocycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "physical_skill")
    private Integer physicalSkill;

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

    public Mesocycle() {
    }

    public Mesocycle(Long id, PhysicalSkills physicalSkill, LocalDate startDate, LocalDate endDate, Macrocycle macrocycle) {
        this.id = id;
        setPhysicalSkill(physicalSkill);
        this.startDate = startDate;
        this.endDate = endDate;
        this.macrocycle = macrocycle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhysicalSkills getPysicalSkills() {
        return PhysicalSkills.valueOf(physicalSkill);
    }

    public void setPhysicalSkill(PhysicalSkills physicalSkill) {
        this.physicalSkill = physicalSkill.getCode();
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

    public Macrocycle getMacrocycle() {
        return macrocycle;
    }

    public void setMacrocycle(Macrocycle macrocycle) {
        this.macrocycle = macrocycle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mesocycle)) return false;
        Mesocycle that = (Mesocycle) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
