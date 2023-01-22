package com.fmkbook.springbootbackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@Entity
@Table(name = "UZYTKOWNIK")
@JsonIgnoreProperties(value = {"rabats", "rezerwacjas"})
public class Uzytkownik {
    @Id
    @Column(name = "IDUZYTKOWNIKA", nullable = false)
    private Integer id;

    @Column(name = "TEL", nullable = false, length = 12)
    private String tel;

    @Column(name = "HASLO", nullable = false, length = 30)
    private String haslo;

    @Column(name = "EMAIL", length = 50)
    private String email;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uzytkownikiduzytkownika")
    private Set<Rabat> rabats = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "uzytkownikiduzytkownika")
    private Set<Rezerwacja> rezerwacjas = new LinkedHashSet<>();

    public Set<Rezerwacja> getRezerwacjas() {
        return rezerwacjas;
    }

    public void setRezerwacjas(Set<Rezerwacja> rezerwacjas) {
        this.rezerwacjas = rezerwacjas;
    }

    public Set<Rabat> getRabats() {
        return rabats;
    }

    public void setRabats(Set<Rabat> rabats) {
        this.rabats = rabats;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}