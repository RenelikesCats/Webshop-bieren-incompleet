package com.rene.bierenwinkel.bieren.dto;

import com.rene.bierenwinkel.bieren.Bier;

public record BiernaamBrouwerNaamAlcPrijsDTO(String bierNaam, String brouwerNaam, long alcoholPerc, long prijs) {
    public BiernaamBrouwerNaamAlcPrijsDTO(Bier bier) {
        this(bier.getNaam(), bier.getBrouwer().getNaam(), bier.getAlcohol(), bier.getPrijs());
    }
}


