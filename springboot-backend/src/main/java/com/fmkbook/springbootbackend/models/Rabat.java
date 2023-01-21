package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "RABAT")
public class Rabat {
    @Id
    @Column(name = "KODRABATOWY", nullable = false, length = 20)
    private String id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "UZYTKOWNIKIDUZYTKOWNIKA")
    private Uzytkownik uzytkownikiduzytkownika;

    @Column(name = "WYSOKOSCRABATU", nullable = false)
    private Double wysokoscrabatu;
    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "rabatkodrabatowy")
    private Set<Rezerwacja> rezerwacjas = new LinkedHashSet<>();

    public Set<Rezerwacja> getRezerwacjas() {
        return rezerwacjas;
    }

    public void setRezerwacjas(Set<Rezerwacja> rezerwacjas) {
        this.rezerwacjas = rezerwacjas;
    }

    public Double getWysokoscrabatu() {
        return wysokoscrabatu;
    }

    public void setWysokoscrabatu(Double wysokoscrabatu) {
        this.wysokoscrabatu = wysokoscrabatu;
    }

    public Uzytkownik getUzytkownikiduzytkownika() {
        return uzytkownikiduzytkownika;
    }

    public void setUzytkownikiduzytkownika(Uzytkownik uzytkownikiduzytkownika) {
        this.uzytkownikiduzytkownika = uzytkownikiduzytkownika;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}