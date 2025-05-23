package com.rene.bierenwinkel.bieren;

import com.rene.bierenwinkel.brouwers.Brouwer;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bieren")
public class Bier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String naam;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brouwerId")
    private Brouwer brouwer;

    private long alcohol;

    private long prijs;

    private int besteld;

    public Bier(String naam, Brouwer brouwer, long alcohol, long prijs, int besteld) {
        this.naam = naam;
        this.brouwer = brouwer;
        this.alcohol = alcohol;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    protected Bier() {
    }

    public void bestel(int aantal) {
        besteld += aantal;
    }

    public Long getId() {
        return id;
    }

    public Brouwer getBrouwer() {
        return brouwer;
    }

    public String getNaam() {
        return naam;
    }

    public long getAlcohol() {
        return alcohol;
    }

    public long getPrijs() {
        return prijs;
    }

    public int getBesteld() {
        return besteld;
    }
}