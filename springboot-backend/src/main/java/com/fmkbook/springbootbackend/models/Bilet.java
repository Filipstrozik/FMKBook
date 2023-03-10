package com.fmkbook.springbootbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "BILET")
public class Bilet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDBILETU", nullable = false)
    private Integer id;

    @Column(name = "CENABILETU")
    private Double cenabiletu = 11.99;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "REZERWACJAIDREZERWACJI", nullable = true)
    private Rezerwacja rezerwacjaidrezerwacji;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "MIEJSCEIDMIEJSCA", nullable = true)
    private Miejsce miejsceidmiejsca;

    @Enumerated(EnumType.STRING)
    private Typbiletu typbiletunazwatypubiletu = Typbiletu.normalny;

    @Enumerated(EnumType.STRING)
    private Typmiejsca typmiejsca = Typmiejsca.standard;

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

    public Typmiejsca getTypmiejsca() {
        return typmiejsca;
    }

    public void setTypmiejsca(Typmiejsca typmiejsca) {
        this.typmiejsca = typmiejsca;
    }
}