package com.example.luizmangerotte.workout.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class DobrasCutaneas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @MapsId
    private Avaliacao avaliacao;

    private Double tricipital;
    private Double subescapular;
    private Double axilarMedia;
    private Double biciptal;
    private Double peitoral;
    private Double supraIliaca;
    private Double supraEspinhal;
    private Double abdominal;
    private Double coxa;
    private Double panturrilha;

    public DobrasCutaneas() {
    }

    public DobrasCutaneas(Long id, Avaliacao avaliacao, Double tricipital, Double subescapular, Double axilarMedia, Double biciptal, Double peitoral, Double supraIliaca, Double supraEspinhal, Double abdominal, Double coxa, Double panturrilha) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.tricipital = tricipital;
        this.subescapular = subescapular;
        this.axilarMedia = axilarMedia;
        this.biciptal = biciptal;
        this.peitoral = peitoral;
        this.supraIliaca = supraIliaca;
        this.supraEspinhal = supraEspinhal;
        this.abdominal = abdominal;
        this.coxa = coxa;
        this.panturrilha = panturrilha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Double getTricipital() {
        return tricipital;
    }

    public void setTricipital(Double tricipital) {
        this.tricipital = tricipital;
    }

    public Double getSubescapular() {
        return subescapular;
    }

    public void setSubescapular(Double subescapular) {
        this.subescapular = subescapular;
    }

    public Double getAxilarMedia() {
        return axilarMedia;
    }

    public void setAxilarMedia(Double axilarMedia) {
        this.axilarMedia = axilarMedia;
    }

    public Double getBiciptal() {
        return biciptal;
    }

    public void setBiciptal(Double biciptal) {
        this.biciptal = biciptal;
    }

    public Double getPeitoral() {
        return peitoral;
    }

    public void setPeitoral(Double peitoral) {
        this.peitoral = peitoral;
    }

    public Double getSupraIliaca() {
        return supraIliaca;
    }

    public void setSupraIliaca(Double supraIliaca) {
        this.supraIliaca = supraIliaca;
    }

    public Double getSupraEspinhal() {
        return supraEspinhal;
    }

    public void setSupraEspinhal(Double supraEspinhal) {
        this.supraEspinhal = supraEspinhal;
    }

    public Double getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(Double abdominal) {
        this.abdominal = abdominal;
    }

    public Double getCoxa() {
        return coxa;
    }

    public void setCoxa(Double coxa) {
        this.coxa = coxa;
    }

    public Double getPanturrilha() {
        return panturrilha;
    }

    public void setPanturrilha(Double panturrilha) {
        this.panturrilha = panturrilha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DobrasCutaneas)) return false;
        DobrasCutaneas that = (DobrasCutaneas) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
