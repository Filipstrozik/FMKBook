package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TYPABONAMENTU")
public class Typabonamentu {
    @Id
    @Column(name = "IDTYPABONAMENTU", nullable = false)
    private Integer id;

    @Column(name = "CENA")
    private Double cena;

    @Column(name = "OPIS")
    private String opis;

    @OneToMany(mappedBy = "typabonamentucolumn")
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
}