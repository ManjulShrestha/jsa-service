package com.am.jsa.candidate.repository;

import com.am.jsa.candidate.entity.CandidateAwards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateAwardsRepository extends JpaRepository<CandidateAwards, Long> {
    @Query("FROM CandidateAwards where id=:id")
    CandidateAwards read(@Param("id") Long id);

}
