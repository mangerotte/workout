package com.example.luizmangerotte.workout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ExercicioSessaoTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zonaRep;
    private Double descanso;
    private String cadencia;
    private Integer numeroSeries;

    @ManyToOne
    @JoinColumn(name = "id_exercicio")
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "id_sessa_treino")
    @JsonIgnore
    private SessaoTreino sessaoTreino;

    @OneToMany(mappedBy = "exercicioSessaoTreino")
    private List<Serie> series = new ArrayList<>();

    public ExercicioSessaoTreino() {
    }

    public ExercicioSessaoTreino(Long id, String zonaRep, Double descanso, String cadencia, Integer numeroSeries, Exercicio exercicio, SessaoTreino sessaoTreino) {
        this.id = id;
        this.zonaRep = zonaRep;
        this.descanso = descanso;
        this.cadencia = cadencia;
        this.numeroSeries = numeroSeries;
        this.exercicio = exercicio;
        this.sessaoTreino = sessaoTreino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZonaRep() {
        return zonaRep;
    }

    public void setZonaRep(String zonaRep) {
        this.zonaRep = zonaRep;
    }

    public Double getDescanso() {
        return descanso;
    }

    public void setDescanso(Double descanso) {
        this.descanso = descanso;
    }

    public String getCadencia() {
        return cadencia;
    }

    public void setCadencia(String cadencia) {
        this.cadencia = cadencia;
    }

    public Integer getNumeroSeries() {
        return numeroSeries;
    }

    public void setNumeroSeries(Integer numeroSeries) {
        this.numeroSeries = numeroSeries;
    }

    public Exercicio getExercicio() {
        return exercicio;
    }

    public void setExercicio(Exercicio exercicio) {
        this.exercicio = exercicio;
    }

    public SessaoTreino getSessaoTreino() {
        return sessaoTreino;
    }

    public void setSessaoTreino(SessaoTreino sessaoTreino) {
        this.sessaoTreino = sessaoTreino;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public Double getVolumeCargaExercicio(){
       Double sum = 0.0;
       for (Serie volume : series){
           sum += volume.getVolumeCargaSerie();
       }
       return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExercicioSessaoTreino)) return false;
        ExercicioSessaoTreino that = (ExercicioSessaoTreino) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
