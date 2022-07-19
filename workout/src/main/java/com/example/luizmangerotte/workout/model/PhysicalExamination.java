package com.example.luizmangerotte.workout.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
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

    public PhysicalExamination(Long id, Instant evaluationDate, Double weight, Double height, Double fatPercentage, Double muscleMass, Client client) {
        this.id = id;
        this.evaluationDate = evaluationDate;
        this.weight = weight;
        this.height = height;
        this.fatPercentage = fatPercentage;
        this.muscleMass = muscleMass;
        this.client = client;
    }
}
