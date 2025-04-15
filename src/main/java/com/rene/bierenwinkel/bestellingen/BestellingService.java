package com.rene.bierenwinkel.bestellingen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BestellingService {
    private BestellingRepository bestellingRepository;

    public BestellingService(BestellingRepository bestellingRepository) {
        this.bestellingRepository = bestellingRepository;
    }


}
