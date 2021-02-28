package com.am.jsa.candidate.repository;


import com.am.jsa.candidate.entity.CandidateEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateEducationRepository extends JpaRepository<CandidateEducation, Long> {

    @Query("FROM CandidateEducation where id=:id")
    CandidateEducation read(@Param("id") Long id);


}
