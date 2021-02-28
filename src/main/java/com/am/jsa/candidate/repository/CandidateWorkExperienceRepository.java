package com.am.jsa.candidate.repository;


import com.am.jsa.candidate.entity.CandidateWorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateWorkExperienceRepository extends JpaRepository<CandidateWorkExperience, Long> {

    @Query("FROM CandidateWorkExperience where id=:id")
    CandidateWorkExperience read(@Param("id") Long id);

    @Query("FROM CandidateWorkExperience  where candidateResume.id = :resumeId")
    List<CandidateWorkExperience> getSearchedCandidateWorkExperience(@Param("resumeId") Long resumeId);
	

}
