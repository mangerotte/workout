package com.example.luizmangerotte.workout.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkinFold {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private PhysicalExamination physicalExamination;

    private Double triceps;
    private Double chest;
    private Double midaxillary;
    private Double biceps;
    private Double subescapular;
    private Double suprailiac;
    private Double thigh;
    private Double abdominal;
    private Double calf;

}
