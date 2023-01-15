package com.fmkbook.springbootbackend.repositories;


import com.fmkbook.springbootbackend.models.Rabat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RabatRepository extends JpaRepository<Rabat, String> {

    void deleteRabatById(String code);

    Optional<Rabat> findRabatById(String code);
}
