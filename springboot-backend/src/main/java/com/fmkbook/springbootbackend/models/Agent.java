package com.fmkbook.springbootbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "AGENT")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDAGENTA", nullable = false)
    private Integer id;

    @Column(name = "TEL", nullable = false, length = 12)
    private String tel;

    @Column(name = "HASLO", nullable = false, length = 30)
    private String haslo;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "agentidagenta")
    private Kino kino;

    public Kino getKino() {
        return kino;
    }

    public void setKino(Kino kino) {
        this.kino = kino;
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