package com.rene.bierenwinkel.brouwers.dto;

import com.rene.bierenwinkel.brouwers.Brouwer;

public record BrouwerNaamGemeentePostcode(long id, String naam, String straat, String huisNr, long postcode,
                                          String gemeente) {
    public BrouwerNaamGemeentePostcode(Brouwer brouwer) {
        this(brouwer.getId(), brouwer.getNaam(), brouwer.getStraat(), brouwer.getHuisNr(), brouwer.getPostcode(), brouwer.getGemeente());
    }
}
