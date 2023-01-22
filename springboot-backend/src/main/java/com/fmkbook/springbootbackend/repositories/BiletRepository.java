package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Bilet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BiletRepository extends JpaRepository<Bilet, Integer> {
}
