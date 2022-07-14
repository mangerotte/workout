package com.example.luizmangerotte.workout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
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

    public SkinFold() {
    }

    public SkinFold(Long id, PhysicalExamination physicalExamination, Double triceps, Double chest, Double midaxillary, Double biceps, Double subescapular, Double suprailiac, Double thigh, Double abdominal, Double calf) {
        this.id = id;
        this.physicalExamination = physicalExamination;
        this.triceps = triceps;
        this.chest = chest;
        this.midaxillary = midaxillary;
        this.biceps = biceps;
        this.subescapular = subescapular;
        this.suprailiac = suprailiac;
        this.thigh = thigh;
        this.abdominal = abdominal;
        this.calf = calf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhysicalExamination getPhysicalExamination() {
        return physicalExamination;
    }

    public void setPhysicalExamination(PhysicalExamination physicalExamination) {
        this.physicalExamination = physicalExamination;
    }

    public Double getTriceps() {
        return triceps;
    }

    public void setTriceps(Double triceps) {
        this.triceps = triceps;
    }

    public Double getChest() {
        return chest;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getMidaxillary() {
        return midaxillary;
    }

    public void setMidaxillary(Double midaxillary) {
        this.midaxillary = midaxillary;
    }

    public Double getBiceps() {
        return biceps;
    }

    public void setBiceps(Double biceps) {
        this.biceps = biceps;
    }

    public Double getSubescapular() {
        return subescapular;
    }

    public void setSubescapular(Double subescapular) {
        this.subescapular = subescapular;
    }

    public Double getSuprailiac() {
        return suprailiac;
    }

    public void setSuprailiac(Double suprailiac) {
        this.suprailiac = suprailiac;
    }

    public Double getThigh() {
        return thigh;
    }

    public void setThigh(Double thigh) {
        this.thigh = thigh;
    }

    public Double getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(Double abdominal) {
        this.abdominal = abdominal;
    }

    public Double getCalf() {
        return calf;
    }

    public void setCalf(Double calf) {
        this.calf = calf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SkinFold)) return false;
        SkinFold that = (SkinFold) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
