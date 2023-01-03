package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "SPOSOBPLATNOSCI")
public class Sposobplatnosci {
    @Id
    @Column(name = "NAZWAMETODY", nullable = false, length = 50)
    private String id;

    @OneToMany(mappedBy = "sposobplatnoscinazwametody")
    private Set<Rezerwacja> rezerwacjas = new LinkedHashSet<>();

    public Set<Rezerwacja> getRezerwacjas() {
        return rezerwacjas;
    }

    public void setRezerwacjas(Set<Rezerwacja> rezerwacjas) {
        this.rezerwacjas = rezerwacjas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}