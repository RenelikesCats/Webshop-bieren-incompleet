package com.rene.bierenwinkel.bestellingen;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BestellingRepository extends JpaRepository<Bestelling, Long> {
}
