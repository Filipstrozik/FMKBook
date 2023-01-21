package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SALA")
@JsonIgnoreProperties(value = {"miejsces"})
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "IDSALI", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KINOIDKINA")
    private Kino kinoidkina;

    @Column(name = "ILOSCMIEJSC")
    private Integer iloscmiejsc;

    @OneToMany(mappedBy = "salaidsali")
    private Set<Miejsce> miejsces = new LinkedHashSet<>();

    public Set<Miejsce> getMiejsces() {
        return miejsces;
    }

    public void setMiejsces(Set<Miejsce> miejsces) {
        this.miejsces = miejsces;
    }

    public Integer getIloscmiejsc() {
        return iloscmiejsc;
    }

    public void setIloscmiejsc(Integer iloscmiejsc) {
        this.iloscmiejsc = iloscmiejsc;
    }

    public Kino getKinoidkina() {
        return kinoidkina;
    }

    public void setKinoidkina(Kino kinoidkina) {
        this.kinoidkina = kinoidkina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}