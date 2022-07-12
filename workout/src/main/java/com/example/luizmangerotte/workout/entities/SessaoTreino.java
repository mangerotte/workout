package com.example.luizmangerotte.workout.entities;


import com.example.luizmangerotte.workout.entities.enums.GrupamentosMusculares;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class SessaoTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate diaTreino;
    private String name;
    private Double intensidade;

    @ManyToOne
    @JoinColumn(name = "id_microciclo")
    @JsonIgnore
    private Microciclo microciclo;

    @OneToMany(mappedBy = "sessaoTreino")
    List<ExercicioSessaoTreino> exeSessaoTreinos = new ArrayList<>();


    public SessaoTreino() {
    }

    public SessaoTreino(Long id, LocalDate diaTreino, String name, Microciclo microciclo, Double intensidade) {
        this.id = id;
        this.diaTreino = diaTreino;
        this.name = name;
        this.microciclo = microciclo;
        this.intensidade = intensidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDiaTreino() {
        return diaTreino;
    }

    public void setDiaTreino(LocalDate diaTreino) {
        this.diaTreino = diaTreino;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Microciclo getMicrociclo() {
        return microciclo;
    }

    public void setMicrociclo(Microciclo microciclo) {
        this.microciclo = microciclo;
    }

    public Double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(Double intensidade) {
        this.intensidade = intensidade;
    }


    public List<ExercicioSessaoTreino> getExeSessaoTreinos() {
        return exeSessaoTreinos;
    }

    public Double getVolumeCargaSessaoTreino(){
        Double sum = 0.0;
        for (ExercicioSessaoTreino volume : exeSessaoTreinos){
            sum += volume.getVolumeCargaExercicio();
        }
        return sum;
    }

    public Integer getNumeroSeriesTotais(GrupamentosMusculares grupamentoMuscular){
        Integer sum = 0;
        for (ExercicioSessaoTreino exercicio : exeSessaoTreinos){
            if (exercicio.getExercicio().getGrupamentoMuscular() == grupamentoMuscular){
                sum += exercicio.getNumeroSeries();
            }
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessaoTreino)) return false;
        SessaoTreino that = (SessaoTreino) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
