package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.pk.ExercicioTreinoPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ExercicioSessaoTreino {

    @EmbeddedId
    private ExercicioTreinoPK id = new ExercicioTreinoPK();
    private String zonaRep;
    private Double descanso;
    private String cadencia;
    private Integer numeroSeries;

    public ExercicioSessaoTreino() {
    }

    public ExercicioSessaoTreino(Exercicio exercicio, SessaoTreino sessaoTreino, String zonaRep, Double descanso, String cadencia, Integer numeroSeries) {
        id.setExercicio(exercicio);
        id.setSessaoTreino(sessaoTreino);
        this.zonaRep = zonaRep;
        this.descanso = descanso;
        this.cadencia = cadencia;
        this.numeroSeries = numeroSeries;
    }


    public Exercicio getExercicio() {
        return id.getExercicio();
    }

    public void setExercicio(Exercicio exercicio) {
        id.setExercicio(exercicio);
    }

    public SessaoTreino getSessaoTreinoo() {
        return id.getSessaoTreino();
    }

    public void setSessaoTreino(SessaoTreino sessaoTreino) {
        id.setSessaoTreino(sessaoTreino);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExercicioSessaoTreino)) return false;
        ExercicioSessaoTreino that = (ExercicioSessaoTreino) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
