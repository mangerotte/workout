package com.example.luizmangerotte.workout.entities.pk;

import com.example.luizmangerotte.workout.entities.Exercicio;
import com.example.luizmangerotte.workout.entities.SessaoTreino;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExercicioTreinoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "exercicio_id")
    private Exercicio exercicio;

    @ManyToOne
    @JoinColumn(name = "sessaotreino_id")
    private SessaoTreino sessaoTreino;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExercicioTreinoPK)) return false;
        ExercicioTreinoPK that = (ExercicioTreinoPK) o;
        return Objects.equals(getExercicio(), that.getExercicio()) && Objects.equals(getSessaoTreino(), that.getSessaoTreino());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getExercicio(), getSessaoTreino());
    }
}
