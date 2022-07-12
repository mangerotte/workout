package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.Periodizacao;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Macrociclo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String objetivo;

        private Integer tipoPeriodizacao;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
        private LocalDate dataInicio;

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
        private LocalDate dataFim;

        @ManyToOne
        @JoinColumn(name = "aluno_id")
        private Aluno aluno;

        @OneToMany(mappedBy = "macrociclo")
        List<Mesociclos> mesociclos = new ArrayList<>();

    public Macrociclo() {
    }

    public Macrociclo(Long id, String objetivo, Periodizacao tipoPeriodizacao, LocalDate dataInicio, LocalDate dataFim, Aluno aluno) {
        this.id = id;
        this.objetivo = objetivo;
        setTipoPeriodizacao(tipoPeriodizacao);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.aluno = aluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Periodizacao getTipoPeriodizacao() {
        return Periodizacao.valueOf(tipoPeriodizacao);
    }

    public void setTipoPeriodizacao(Periodizacao tipoPeriodizacao) {
        this.tipoPeriodizacao = tipoPeriodizacao.getCode();
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno that = (Aluno) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
