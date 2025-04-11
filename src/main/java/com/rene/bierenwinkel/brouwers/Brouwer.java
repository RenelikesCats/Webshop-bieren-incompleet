package com.rene.bierenwinkel.brouwers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "brouwers")
public class Brouwer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;


    private String straat;

    private String huisNr;

    private Short postcode;

    private String gemeente;

    private Long omzet;

    public Brouwer(String naam, String straat, Short postcode, String huisNr, String gemeente, Long omzet) {
        this.naam = naam;
        this.straat = straat;
        this.postcode = postcode;
        this.huisNr = huisNr;
        this.gemeente = gemeente;
        this.omzet = omzet;
    }

    protected Brouwer() {
    }

    public String getNaam() {
        return naam;
    }

    public Long getId() {
        return id;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public Short getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    public Long getOmzet() {
        return omzet;
    }
}