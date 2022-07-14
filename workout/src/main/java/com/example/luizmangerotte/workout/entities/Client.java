package com.example.luizmangerotte.workout.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Client extends RepresentationModel<Client> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate startDate;
    private boolean status;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<PhysicalExamination> physicalExaminationList = new ArrayList<>();

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Macrocycle> macrocyclesList = new ArrayList<>();

    public Client() {
    }

    public Client(Long id, String name, LocalDate startDate, boolean status) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<PhysicalExamination> getPhysicalExaminationList() {
        return physicalExaminationList;
    }

    public List<Macrocycle> getMacrociclos() {
        return macrocyclesList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return Objects.equals(getId(), client.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
