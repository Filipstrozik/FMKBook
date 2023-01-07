package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "SEANS")
public class Seans {
    @Id
    @Column(name = "IDSEANSU", nullable = false)
    private Integer id;

    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Column(name = "CZAS", nullable = false)
    private Instant czas;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "KINOIDKINA", nullable = false)
    private Kino kinoidkina;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "FILMIDFILMU", nullable = false)
    private Film filmidfilmu;

    @Column(name = "CENASEANSU", nullable = false)
    private Double cenaseansu;

    public Double getCenaseansu() {
        return cenaseansu;
    }

    public void setCenaseansu(Double cenaseansu) {
        this.cenaseansu = cenaseansu;
    }

    public Film getFilmidfilmu() {
        return filmidfilmu;
    }

    public void setFilmidfilmu(Film filmidfilmu) {
        this.filmidfilmu = filmidfilmu;
    }

    public Kino getKinoidkina() {
        return kinoidkina;
    }

    public void setKinoidkina(Kino kinoidkina) {
        this.kinoidkina = kinoidkina;
    }

    public Instant getCzas() {
        return czas;
    }

    public void setCzas(Instant czas) {
        this.czas = czas;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}