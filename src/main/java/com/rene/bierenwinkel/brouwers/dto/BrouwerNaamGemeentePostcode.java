package com.rene.bierenwinkel.brouwers.dto;

import com.rene.bierenwinkel.brouwers.Brouwer;

public record BrouwerNaamGemeentePostcode(String naam, String gemeente, long postcode) {
    public BrouwerNaamGemeentePostcode(Brouwer brouwer) {
        this(brouwer.getNaam(), brouwer.getGemeente(), brouwer.getPostcode());
    }
}
