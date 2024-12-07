package com.example.stratyp.declaration.repository;

import com.example.stratyp.declaration.entity.Declarations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public interface DeclarationRepository extends JpaRepository<Declarations, Long> {
    @Query("SELECT COUNT(d) FROM Declarations d WHERE d.user.id = :userId AND FUNCTION('MONTH', d.declarationDate) = :month AND FUNCTION('YEAR', d.declarationDate) = :year")
    long countDeclarationsForUserInMonth(@Param("userId") Long userId, @Param("month") int month, @Param("year") int year);

    @Query("SELECT d FROM Declarations d WHERE d.user.id = :userId AND DATE(d.declarationDate) = DATE(:declarationDate)")
    Optional<Declarations> findByUserAndDate(@Param("userId") Long userId, @Param("declarationDate") Date declarationDate);

    @Query("SELECT D FROM Declarations D " +
            "INNER JOIN D.user U " +
            "WHERE U.kvd_sg.id = :userKvdId " +
            "ORDER BY D.declarationDate ASC") // Κατά φθίνουσα σειρά, ή ASC για αύξουσα
    List<Declarations> findDeclarationsByASG(@Param("userKvdId") Long userKvdId);

    @Query("SELECT D FROM Declarations D WHERE FUNCTION('MONTH', D.declarationDate) = :month AND FUNCTION('YEAR', D.declarationDate) = :year")
    List<Declarations> getDeclarationsForMonthAndYear(@Param("month") int month, @Param("year") int year);

}
