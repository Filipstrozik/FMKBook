package com.fmkbook.springbootbackend.repositories;


import com.fmkbook.springbootbackend.models.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Integer> {

    void deleteUzytkownikById(Integer id);

    Optional<Uzytkownik> findUzytkownikById(Integer id);
}
