package com.example.hck1.TiposGrupos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TiposgruposRepository extends JpaRepository<Tiposgrupos, Long> {
    Optional<Tiposgrupos> findById(Long id);
}
