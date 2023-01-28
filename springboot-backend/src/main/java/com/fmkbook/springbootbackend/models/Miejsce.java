package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "MIEJSCE")
@JsonIgnoreProperties(value = {"bilets"})
public class Miejsce {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDMIEJSCA", nullable = false)
    private Integer id;

    @Column(name = "RZAD", nullable = false, length = 100)
    private String rzad;

    @Column(name = "KOLUMNA", nullable = false, length = 100)
    private String kolumna;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "SALAIDSALI", nullable = true)
    private Sala salaidsali;

    @OneToMany(mappedBy = "miejsceidmiejsca")
    private Set<Bilet> bilets = new LinkedHashSet<>();

    public Set<Bilet> getBilets() {
        return bilets;
    }

    public void setBilets(Set<Bilet> bilets) {
        this.bilets = bilets;
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