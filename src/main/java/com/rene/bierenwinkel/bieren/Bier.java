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

    private BigDecimal alcohol;

    private BigDecimal prijs;


    @Column(name = "besteld")
    private Long besteld;

    public Bier(String naam, Brouwer brouwer, BigDecimal alcohol, BigDecimal prijs, Long besteld) {
        this.naam = naam;
        this.brouwer = brouwer;
        this.alcohol = alcohol;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    protected Bier() {
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

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public Long getBesteld() {
        return besteld;
    }
}