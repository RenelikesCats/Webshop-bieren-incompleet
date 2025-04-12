package com.rene.bierenwinkel.brouwers;

import com.rene.bierenwinkel.brouwers.dto.BrouwerNaamGemeentePostcode;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("brouwers")
public class BrouwerController {
    private final BrouwerService brouwerService;

    public BrouwerController(BrouwerService brouwerService) {
        this.brouwerService = brouwerService;
    }

    @Operation(summary = "Geeft brouwers terug, filter toegepast")
    @GetMapping
    Stream<BrouwerNaamGemeentePostcode> findAll() {
        return brouwerService.findAllBrouwers().stream().map(BrouwerNaamGemeentePostcode::new);
    }
}
