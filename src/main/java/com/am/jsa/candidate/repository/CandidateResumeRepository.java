package com.am.jsa.candidate.repository;

import com.am.jsa.candidate.entity.CandidateResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateResumeRepository extends JpaRepository<CandidateResume, Long> {

    @Query("FROM CandidateResume where candidate.id=:candidateId")
    CandidateResume getCandidateResumeByCandidateId(@Param("candidateId") Long candidateId);

    @Query("FROM CandidateResume where id=:id")
    CandidateResume read(@Param("id") Long id);

}
