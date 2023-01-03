package com.fmkbook.springbootbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "BILET")
public class Bilet {
    @Id
    @Column(name = "IDBILETU", nullable = false)
    private Integer id;

    @Column(name = "CENABILETU")
    private Double cenabiletu;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "REZERWACJAIDREZERWACJI", nullable = false)
    private Rezerwacja rezerwacjaidrezerwacji;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MIEJSCEIDMIEJSCA", nullable = false)
    private Miejsce miejsceidmiejsca;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPBILETUNAZWATYPUBILETU", nullable = false)
    private Typbiletu typbiletunazwatypubiletu;

    public Typbiletu getTypbiletunazwatypubiletu() {
        return typbiletunazwatypubiletu;
    }

    public void setTypbiletunazwatypubiletu(Typbiletu typbiletunazwatypubiletu) {
        this.typbiletunazwatypubiletu = typbiletunazwatypubiletu;
    }

    public Miejsce getMiejsceidmiejsca() {
        return miejsceidmiejsca;
    }

    public void setMiejsceidmiejsca(Miejsce miejsceidmiejsca) {
        this.miejsceidmiejsca = miejsceidmiejsca;
    }

    public Rezerwacja getRezerwacjaidrezerwacji() {
        return rezerwacjaidrezerwacji;
    }

    public void setRezerwacjaidrezerwacji(Rezerwacja rezerwacjaidrezerwacji) {
        this.rezerwacjaidrezerwacji = rezerwacjaidrezerwacji;
    }

    public Double getCenabiletu() {
        return cenabiletu;
    }

    public void setCenabiletu(Double cenabiletu) {
        this.cenabiletu = cenabiletu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}