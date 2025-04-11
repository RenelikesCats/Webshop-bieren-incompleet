package com.rene.bierenwinkel.brouwers;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BrouwerService {
    private final BrouwerRepository brouwerRepository;
    public BrouwerService(BrouwerRepository brouwerRepository) {
        this.brouwerRepository = brouwerRepository;

    }

    List<Brouwer> findAllBrouwers() {
        return brouwerRepository.findAll();
    }
}


