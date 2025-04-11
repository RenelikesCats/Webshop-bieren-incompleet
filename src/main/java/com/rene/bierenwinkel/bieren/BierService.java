package com.rene.bierenwinkel.bieren;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    List<Bier> findBierenByBrouwerId(long id) {
        return bierRepository.findBierenByBrouwerId(id);

    }

    long countBierenByBrouwerId(long id) {
        return bierRepository.countBierByBrouwer_Id(id);
    }
}
