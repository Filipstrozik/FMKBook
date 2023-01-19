package com.fmkbook.springbootbackend.models;

import javax.persistence.*;

@Entity
@Table(name = "ABONAMENT")
public class Abonament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDABONAMENTU",unique=true, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPABONAMENTUCOLUMN")
    private Typabonamentu typabonamentucolumn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "UZYTKOWNIKIDUZYTKOWNIKA", nullable = false)
    private Uzytkownik uzytkownikiduzytkownika;

    public Uzytkownik getUzytkownikiduzytkownika() {
        return uzytkownikiduzytkownika;
    }

    public void setUzytkownikiduzytkownika(Uzytkownik uzytkownikiduzytkownika) {
        this.uzytkownikiduzytkownika = uzytkownikiduzytkownika;
    }

    public Typabonamentu getTypabonamentucolumn() {
        return typabonamentucolumn;
    }

    public void setTypabonamentucolumn(Typabonamentu typabonamentucolumn) {
        this.typabonamentucolumn = typabonamentucolumn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}