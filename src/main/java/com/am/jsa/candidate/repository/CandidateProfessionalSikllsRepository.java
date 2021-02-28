package com.am.jsa.candidate.repository;

import com.am.jsa.candidate.entity.CandidateProfessionalSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateProfessionalSikllsRepository extends JpaRepository<CandidateProfessionalSkills, Long> {

    @Query("FROM CandidateProfessionalSkills where id=:id")
    CandidateProfessionalSkills read(@Param("id") Long id);
	

}
