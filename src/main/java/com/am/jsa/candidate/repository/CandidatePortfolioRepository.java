package com.am.jsa.candidate.repository;

import com.am.jsa.candidate.entity.CandidatePortFolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidatePortfolioRepository extends JpaRepository<CandidatePortFolio, Long> {

    @Query("FROM CandidatePortFolio where id=:id")
    CandidatePortFolio read(@Param("id") Long id);

}
