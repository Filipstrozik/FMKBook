package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "FILM")
@JsonIgnoreProperties(value = {"seans"})
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDFILMU", nullable = false)
    private Integer id;

    @Column(name = "TYTUL", nullable = false, length = 50)
    private String tytul;

    @Column(name = "GATUNEK", length = 50)
    private String gatunek;

    @Column(name = "OPIS", columnDefinition = "LONGTEXT")
    private String opis;

    @Column(name = "IMAGEPATH")
    private String imagePath;

    @Column(name = "DLUGOSC")
    private Integer dlugosc;

    @OneToMany(mappedBy = "filmidfilmu")
    private Set<Seans> seans;

    public Set<Seans> getSeans() {
        return seans;
    }

    public void setSeans(Set<Seans> seans) {
        this.seans = seans;
    }

    public Integer getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(Integer dlugosc) {
        this.dlugosc = dlugosc;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}