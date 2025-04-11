package com.rene.bierenwinkel.bieren;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class BierService {
    private final BierRepository bierRepository;

    public BierService(BierRepository bierRepository) {
        this.bierRepository = bierRepository;
    }

    long findAantalBieren() {
        return bierRepository.count();
    }
}
