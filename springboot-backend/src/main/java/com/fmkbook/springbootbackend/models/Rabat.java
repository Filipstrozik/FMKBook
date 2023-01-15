package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "RABAT")
public class Rabat {
    @Id
    @Column(name = "KODRABATOWY", nullable = false, length = 20)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UZYTKOWNIKIDUZYTKOWNIKA")
    private Uzytkownik uzytkownikiduzytkownika;

    @Column(name = "WYSOKOSCRABATU", nullable = false)
    private Double wysokoscrabatu;

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