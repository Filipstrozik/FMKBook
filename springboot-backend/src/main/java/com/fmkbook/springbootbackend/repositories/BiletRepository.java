package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Bilet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiletRepository extends JpaRepository<Bilet, Integer> {

}
