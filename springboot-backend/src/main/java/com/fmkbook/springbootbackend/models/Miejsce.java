package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MIEJSCE")
public class Miejsce {
    @Id
    @Column(name = "IDMIEJSCA", nullable = false)
    private Integer id;

    @Column(name = "RZAD", nullable = false, length = 100)
    private String rzad;

    @Column(name = "KOLUMNA", nullable = false, length = 100)
    private String kolumna;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SALAIDSALI", nullable = false)
    private Sala salaidsali;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPMIEJSCANAZWATYPUMIEJSCA", nullable = false)
    private Typmiejsca typmiejscanazwatypumiejsca;

    @OneToMany(mappedBy = "miejsceidmiejsca")
    private Set<Bilet> bilets = new LinkedHashSet<>();

    public Set<Bilet> getBilets() {
        return bilets;
    }

    public void setBilets(Set<Bilet> bilets) {
        this.bilets = bilets;
    }

    public Typmiejsca getTypmiejscanazwatypumiejsca() {
        return typmiejscanazwatypumiejsca;
    }

    public void setTypmiejscanazwatypumiejsca(Typmiejsca typmiejscanazwatypumiejsca) {
        this.typmiejscanazwatypumiejsca = typmiejscanazwatypumiejsca;
    }

    public Sala getSalaidsali() {
        return salaidsali;
    }

    public void setSalaidsali(Sala salaidsali) {
        this.salaidsali = salaidsali;
    }

    public String getKolumna() {
        return kolumna;
    }

    public void setKolumna(String kolumna) {
        this.kolumna = kolumna;
    }

    public String getRzad() {
        return rzad;
    }

    public void setRzad(String rzad) {
        this.rzad = rzad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}