package com.rene.bierenwinkel.bestellingen;

import jakarta.persistence.*;

@Entity
@Table(name = "bestellingen")
public class Bestelling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;


    private String straat;


    private String huisnummer;


    private long postcode;


    private String gemeente;

    public Long getId() {
        return id;
    }


    public String getNaam() {
        return naam;
    }


    public String getStraat() {
        return straat;
    }


    public String getHuisnummer() {
        return huisnummer;
    }


    public long getPostcode() {
        return postcode;
    }


    public String getGemeente() {
        return gemeente;
    }


}