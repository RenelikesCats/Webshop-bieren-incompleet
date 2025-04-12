package com.rene.bierenwinkel.bieren;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

interface BierRepository extends JpaRepository<Bier, Long> {

    List<Bier> findBierenByBrouwerId(Long id);
    long countBierByBrouwer_Id(Long brouwerId);

    @EntityGraph(attributePaths = {"brouwer"})
    List<Bier> findAll();
}
