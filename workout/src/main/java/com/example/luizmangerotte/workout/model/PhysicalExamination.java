package com.example.luizmangerotte.workout.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
public class PhysicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    @Column(name = "evaluation_date")
    private Instant evaluationDate;
    private Double weight;
    private Double height;
    @Column(name = "fat_percentage")
    private Double fatPercentage;
    @Column(name = "muscle_mass")
    private Double muscleMass;

    @OneToOne(mappedBy = "physicalExamination", cascade = CascadeType.ALL)
    private SkinFold skinFold;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    public PhysicalExamination() {
    }

    public PhysicalExamination(Long id, Client client, Instant evaluationDate, Double weight, Double height, Double fatPercentage, Double muscleMass) {
        this.id = id;
        this.client = client;
        this.evaluationDate = evaluationDate;
        this.weight = weight;
        this.height = height;
        this.fatPercentage = fatPercentage;
        this.muscleMass = muscleMass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(Instant evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getFatPercentage() {
        return fatPercentage;
    }

    public void setFatPercentage(Double fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    public Double getMuscleMass() {
        return muscleMass;
    }

    public void setMuscleMass(Double muscleMass) {
        this.muscleMass = muscleMass;
    }

    public SkinFold getSkinFold() {
        return skinFold;
    }

    public void setSkinFold(SkinFold skinFold) {
        this.skinFold = skinFold;
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
        if (!(o instanceof PhysicalExamination)) return false;
        PhysicalExamination physicalExamination = (PhysicalExamination) o;
        return Objects.equals(getId(), physicalExamination.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
