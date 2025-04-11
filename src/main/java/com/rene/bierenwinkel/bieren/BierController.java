package com.rene.bierenwinkel.bieren;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bieren")
public class BierController {

    private final BierService bierService;

    public BierController(BierService bierService) {
        this.bierService = bierService;
    }

    @GetMapping("/findAantalBieren")
    Long findAantalBieren() {
        return bierService.findAantalBieren();
    }
}
