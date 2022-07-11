package com.example.luizmangerotte.workout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dataInicio;
    private boolean status;

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Avaliacao> avaliacaoList = new ArrayList<>();

    @OneToMany(mappedBy = "aluno")
    @JsonIgnore
    private List<Macrociclo> macrociclos = new ArrayList<>();

    public Aluno() {
    }

    public Aluno(Long id, String name, LocalDate dataInicio, boolean status) {
        this.id = id;
        this.name = name;
        this.dataInicio = dataInicio;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDatainicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Avaliacao> getAvaliacaoList() {
        return avaliacaoList;
    }

    public List<Macrociclo> getMacrociclos() {
        return macrociclos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getId(), aluno.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
