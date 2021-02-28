package com.am.jsa.job.repository;

import com.am.jsa.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

	@Query("FROM Job WHERE id = ?1")
	Job read(long id);

	@Query("Select count(entity) FROM Job entity where entity.company.id = :companyId")
	Long getJobCount(@Param("companyId") Long companyId);

	@Query("Select count(entity) FROM Job entity where entity.active = true")
	Long getTotalJobCount();

	@Query("Select entity.id FROM Job entity where entity.company.id=?1")
	List<Integer> getJobsOfCompany(int companyId);

	@Query("FROM Job where category.id in ?1")
	List<Job>  getJobByCategory(List<Integer> categoryIds);

	@Query("Select count(entity) FROM Job entity where entity.category.id in ?1")
	Long  getJobCountByCategory(List<Integer> categoryIds);

	@Query("SELECT entity FROM Job entity join entity.candidateApplicationSetId cas where cas = :candidateId")
	List<Job> getAppliedJobs(@Param("candidateId") Long candidateId) ;

	@Query("SELECT count(entity) FROM Job entity join entity.candidateApplicationSetId cas where cas = :candidateId")
	Long getAppliedJobsCount(@Param("candidateId") Long candidateId);

	@Query("SELECT entity.company.id FROM Job entity  where entity.id = :jobId")
	Long getCompanyIdByJobId(@Param("jobId") Long jobId);


}
