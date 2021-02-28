package com.am.jsa.job.repository;

import com.am.jsa.job.entity.JobCandidateApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobCandidateApplication, Long> {


	@Query("FROM JobCandidateApplication where jobId in ?1")
    List<JobCandidateApplication> getSearchedApplicaton(List<Integer> jobIds) ;

	@Modifying(clearAutomatically = true)
	@Query("UPDATE JobCandidateApplication entity set entity.shortlisted=:shortListed where entity.jobId=:jobId AND entity.candidateId = :candidateId")
    int shortList(@Param("shortListed") Boolean shortListed, @Param("jobId") Long jobId ,@Param("candidateId") Long candidateId );

}
