package com.rene.bierenwinkel.bieren;

import com.rene.bierenwinkel.bieren.dto.BiernaamBrouwerNaamAlcPrijsDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/brouwer/{id}")
    List<BiernaamBrouwerNaamAlcPrijsDTO> findBierenByBrouwerId(@PathVariable long id) {
        return bierService.findBierenByBrouwerId(id).stream().map(BiernaamBrouwerNaamAlcPrijsDTO::new).toList();
    }

    @GetMapping("/brouwer/aantal/{id}")
    long countBierenByBrouwerId(@PathVariable long id) {
        return bierService.countBierenByBrouwerId(id);
    }
}
