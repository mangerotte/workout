package com.example.luizmangerotte.workout.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double carga;
    private Integer repeticao;

    @ManyToOne
    @JoinColumn(name = "id_exercicio_sessao")
    @JsonIgnore
    private ExercicioSessaoTreino exercicioSessaoTreino;

    public Serie() {
    }

    public Serie(Long id, Double carga, Integer repeticao, ExercicioSessaoTreino exercicioSessaoTreino) {
        this.id = id;
        this.carga = carga;
        this.repeticao = repeticao;
        this.exercicioSessaoTreino = exercicioSessaoTreino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Integer getRepeticao() {
        return repeticao;
    }

    public void setRepeticao(Integer repeticao) {
        this.repeticao = repeticao;
    }

    public Double getVolumeCargaSerie(){
        return repeticao * carga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Serie)) return false;
        Serie serie = (Serie) o;
        return Objects.equals(getId(), serie.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
