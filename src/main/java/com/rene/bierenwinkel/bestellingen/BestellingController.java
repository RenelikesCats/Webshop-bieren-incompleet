package com.rene.bierenwinkel.bestellingen;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class BestellingController {
    private final BestellingService bestellingService;

    public BestellingController(BestellingService bestellingService) {
        this.bestellingService = bestellingService;
    }
    //TODO
    //bestelling kunnen aanmaken

}
