package com.example.luizmangerotte.workout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @JsonIgnore
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
