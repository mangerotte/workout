package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.CapacidadesFisicas;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Mesociclos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer capacidadeFisica;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "id_macrociclo")
    private Macrociclo macrociclo;

    @OneToMany(mappedBy = "mesociclos")
    private List<Microciclo> microciclos = new ArrayList<>();

    public Mesociclos() {
    }

    public Mesociclos(Long id, CapacidadesFisicas capacidadeFisica, LocalDate dataInicio, LocalDate dataFim, Macrociclo macrociclo) {
        this.id = id;
        setCapacidadeFisica(capacidadeFisica);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.macrociclo = macrociclo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CapacidadesFisicas getCapacidadeFisica() {
        return CapacidadesFisicas.valueOf(capacidadeFisica);
    }

    public void setCapacidadeFisica(CapacidadesFisicas capacidadeFisica) {
        this.capacidadeFisica = capacidadeFisica.getCode();
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

    public Macrociclo getMacrociclo() {
        return macrociclo;
    }

    public void setMacrociclo(Macrociclo macrociclo) {
        this.macrociclo = macrociclo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mesociclos)) return false;
        Mesociclos that = (Mesociclos) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
