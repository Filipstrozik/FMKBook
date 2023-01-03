package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SEANS")
public class Sean {
    @Id
    @Column(name = "IDSEANSU", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FILMIDFILMU")
    private Film filmidfilmu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KINOIDKINA")
    private Kino kinoidkina;

    @Column(name = "\"DATA\"")
    private LocalDate data;

    @Column(name = "CZAS")
    private Instant czas;

    @OneToMany(mappedBy = "seansidseansu")
    private Set<Rezerwacja> rezerwacjas = new LinkedHashSet<>();

    public Set<Rezerwacja> getRezerwacjas() {
        return rezerwacjas;
    }

    public void setRezerwacjas(Set<Rezerwacja> rezerwacjas) {
        this.rezerwacjas = rezerwacjas;
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

    public Kino getKinoidkina() {
        return kinoidkina;
    }

    public void setKinoidkina(Kino kinoidkina) {
        this.kinoidkina = kinoidkina;
    }

    public Film getFilmidfilmu() {
        return filmidfilmu;
    }

    public void setFilmidfilmu(Film filmidfilmu) {
        this.filmidfilmu = filmidfilmu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}