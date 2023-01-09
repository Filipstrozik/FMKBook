package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "KINO")
public class Kino {
    @Id
    @Column(name = "IDKINA", nullable = false)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENTIDAGENTA")
    private Agent agentidagenta;

    @Column(name = "ADRES", nullable = false)
    private String adres;

    @OneToMany(mappedBy = "kinoidkina")
    private Set<Seans> seans = new LinkedHashSet<>();

    @OneToMany(mappedBy = "kinoidkina")
    private Set<Sala> salas = new LinkedHashSet<>();

    public Set<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }

    public Set<Seans> getSeans() {
        return seans;
    }

    public void setSeans(Set<Seans> seans) {
        this.seans = seans;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Agent getAgentidagenta() {
        return agentidagenta;
    }

    public void setAgentidagenta(Agent agentidagenta) {
        this.agentidagenta = agentidagenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}