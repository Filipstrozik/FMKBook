package com.fmkbook.springbootbackend.models;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;


public enum Typmiejsca {
    VIP, standard
}

//@Entity
//@Table(name = "TYPMIEJSCA")
//public enum Typmiejsca {
//    @Id
//    @Column(name = "NAZWATYPUMIEJSCA", nullable = false, length = 50)
//    private String id;
//
//
//    @OneToMany(mappedBy = "typmiejscanazwatypumiejsca")
//    private Set<Miejsce> miejsces = new LinkedHashSet<>();
//
//    public Set<Miejsce> getMiejsces() {
//        return miejsces;
//    }
//
//    public void setMiejsces(Set<Miejsce> miejsces) {
//        this.miejsces = miejsces;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    }