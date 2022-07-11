package com.example.luizmangerotte.workout.entities;

import com.example.luizmangerotte.workout.entities.enums.TiposMicrociclos;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Microciclo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tipoDeMicrociclo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate dataInicio;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "id_mesociclos")
    private Mesociclos mesociclos;

    @OneToMany(mappedBy = "microciclo")
    @JsonIgnore
    private List<SessaoTreino> sessoesTreinos = new ArrayList<>();

    public Microciclo() {
    }

    public Microciclo(Long id, TiposMicrociclos tipoDeMicrociclo, LocalDate dataInicio, LocalDate dataFim, Mesociclos mesociclos) {
        this.id = id;
        setTipoDeMicrociclo(tipoDeMicrociclo);
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.mesociclos = mesociclos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TiposMicrociclos getTipoDeMicrociclo() {
        return TiposMicrociclos.valueOf(tipoDeMicrociclo);
    }

    public void setTipoDeMicrociclo(TiposMicrociclos tipoDeMicrociclo) {
        this.tipoDeMicrociclo = tipoDeMicrociclo.getCode();
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

    public Mesociclos getMesociclos() {
        return mesociclos;
    }

    public void setMesociclos(Mesociclos mesociclos) {
        this.mesociclos = mesociclos;
    }

    public List<SessaoTreino> getSessoesTreinos() {
        return sessoesTreinos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Microciclo)) return false;
        Microciclo that = (Microciclo) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}