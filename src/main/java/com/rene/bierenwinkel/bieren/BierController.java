package com.rene.bierenwinkel.bieren;

import com.rene.bierenwinkel.bieren.dto.BiernaamBrouwerNaamAlcPrijsDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("bieren")
public class BierController {

    private final BierService bierService;

    public BierController(BierService bierService) {
        this.bierService = bierService;
    }

    @Operation(summary = "Geeft aantal bieren terug van hele DB. Wordt gebruikt op index.html")
    @GetMapping("/findAantalBieren")
    Long findAantalBieren() {
        return bierService.findAantalBieren();
    }

    @Operation(summary = "Geeft alle bieren terug")
    @GetMapping()
    Stream<BiernaamBrouwerNaamAlcPrijsDTO> findAll() {
        return bierService.findAll().stream().map(BiernaamBrouwerNaamAlcPrijsDTO::new);
    }

    @Operation(summary = "Geeft alle bieren van een specifiek brouwer")
    @GetMapping("/{id}")
    List<BiernaamBrouwerNaamAlcPrijsDTO> findBierenByBrouwerId(@PathVariable long id) {
        return bierService.findBierenByBrouwerId(id).stream().map(BiernaamBrouwerNaamAlcPrijsDTO::new).toList();
    }

    @Operation(summary = "Het aantal bieren van een specifiek brouwer")
    @GetMapping("/brouwer/aantal/{id}")
    long countBierenByBrouwerId(@PathVariable long id) {
        return bierService.countBierenByBrouwerId(id);
    }


}
