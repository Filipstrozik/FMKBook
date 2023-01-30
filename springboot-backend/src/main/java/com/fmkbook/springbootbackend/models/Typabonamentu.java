package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TYPABONAMENTU")
@JsonIgnoreProperties(value = {"abonaments"})
public class Typabonamentu {
    @Id
    @Column(name = "IDTYPABONAMENTU", nullable = false)
    private Integer id;

    @Column(name = "CENA")
    private Double cena;

    @Column(name = "OPIS")
    private String opis;

    @Column(name = "TYTYUL")
    private String tytul;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "typabonamentucolumn")
    private Set<Abonament> abonaments = new LinkedHashSet<>();

    public Set<Abonament> getAbonaments() {
        return abonaments;
    }

    public void setAbonaments(Set<Abonament> abonaments) {
        this.abonaments = abonaments;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }
}