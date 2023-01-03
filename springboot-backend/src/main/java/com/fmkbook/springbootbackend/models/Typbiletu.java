package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TYPBILETU")
public class Typbiletu {
    @Id
    @Column(name = "NAZWATYPUBILETU", nullable = false, length = 50)
    private String id;

    @OneToMany(mappedBy = "typbiletunazwatypubiletu")
    private Set<Bilet> bilets = new LinkedHashSet<>();

    public Set<Bilet> getBilets() {
        return bilets;
    }

    public void setBilets(Set<Bilet> bilets) {
        this.bilets = bilets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}