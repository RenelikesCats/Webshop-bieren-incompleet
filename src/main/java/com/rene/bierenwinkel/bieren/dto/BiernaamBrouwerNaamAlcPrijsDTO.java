package com.rene.bierenwinkel.bieren.dto;

import com.rene.bierenwinkel.bieren.Bier;

public record BiernaamBrouwerNaamAlcPrijsDTO(long id,String bierNaam, String brouwerNaam, long alcoholPerc, long prijs) {
    public BiernaamBrouwerNaamAlcPrijsDTO(Bier bier) {
        this(bier.getId(),bier.getNaam(), bier.getBrouwer().getNaam(), bier.getAlcohol(), bier.getPrijs());
    }
}


