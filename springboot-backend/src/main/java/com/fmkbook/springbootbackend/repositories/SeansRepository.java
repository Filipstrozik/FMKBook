package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Seans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeansRepository extends JpaRepository<Seans, Integer> {

}
