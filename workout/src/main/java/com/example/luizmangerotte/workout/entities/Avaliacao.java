package com.example.luizmangerotte.workout.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Instant dataAvaliacao;
    private Double peso;
    private Double altura;
    private Double percentualGordura;
    private Double massaMuscular;

    @OneToOne(mappedBy = "avaliacao", cascade = CascadeType.ALL)
    private DobrasCutaneas dobrasCutaneas;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    public Avaliacao() {
    }

    public Avaliacao(Long id, Aluno aluno, Instant dataAvaliacao, Double peso, Double altura, Double percentualGordura, Double massaMuscular) {
        this.id = id;
        this.aluno = aluno;
        this.dataAvaliacao = dataAvaliacao;
        this.peso = peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        this.massaMuscular = massaMuscular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Instant getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Instant dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(Double percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public Double getMassaMuscular() {
        return massaMuscular;
    }

    public void setMassaMuscular(Double massaMuscular) {
        this.massaMuscular = massaMuscular;
    }

    public DobrasCutaneas getDobrasCutaneas() {
        return dobrasCutaneas;
    }

    public void setDobrasCutaneas(DobrasCutaneas dobrasCutaneas) {
        this.dobrasCutaneas = dobrasCutaneas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Avaliacao)) return false;
        Avaliacao avaliacao = (Avaliacao) o;
        return Objects.equals(getId(), avaliacao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
