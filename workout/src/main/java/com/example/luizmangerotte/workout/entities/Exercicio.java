package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.GrupamentosMusculares;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer grupamentosMusculares;

    private String videoUrl;

    public Exercicio() {
    }

    public Exercicio(Long id, String name, GrupamentosMusculares grupamentosMusculares, String videoUrl) {
        Id = id;
        this.name = name;
        setGrupamentoMuscular(grupamentosMusculares);
        this.videoUrl = videoUrl;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GrupamentosMusculares getGrupamentoMuscular() {
        return GrupamentosMusculares.valueOf(grupamentosMusculares);
    }

    public void setGrupamentoMuscular(GrupamentosMusculares grupamentosMusculares) {
        this.grupamentosMusculares = grupamentosMusculares.getCode();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exercicio)) return false;
        Exercicio exercicio = (Exercicio) o;
        return Objects.equals(getId(), exercicio.getId()) && Objects.equals(getName(), exercicio.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
