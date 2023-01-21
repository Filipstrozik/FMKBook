package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "KINO")
@JsonIgnoreProperties(value = {"seans", "salas"})
public class Kino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDKINA", nullable = false)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AGENTIDAGENTA", nullable = true)
    private Agent agentidagenta;

    @Column(name = "ADRES", nullable = false)
    private String adres;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY ,mappedBy = "kinoidkina")
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