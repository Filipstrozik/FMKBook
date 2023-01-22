package com.fmkbook.springbootbackend.repositories;

import com.fmkbook.springbootbackend.models.Miejsce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MiejsceRepository extends JpaRepository<Miejsce, Integer> {
    List<Miejsce> findAllBySalaidsaliId(Integer id);

    @Query(value = "SELECT * FROM MIEJSCE WHERE SALAIDSALI = " +
            "(SELECT SALA_IDSALI FROM SEANS WHERE IDSEANSU = :seansId) " +
            "MINUS SELECT M.* FROM BILET JOIN MIEJSCE M on BILET.MIEJSCEIDMIEJSCA = M.IDMIEJSCA " +
            "JOIN REZERWACJA R2 on BILET.REZERWACJAIDREZERWACJI = R2.IDREZERWACJI " +
            "JOIN SEANS S2 on R2.SEANSIDSEANSU = S2.IDSEANSU WHERE IDSEANSU = :seansId"
    ,nativeQuery = true)
    List<Miejsce> findFreeMiejsceBySeans(@Param("seansId") Integer seansId);
}
