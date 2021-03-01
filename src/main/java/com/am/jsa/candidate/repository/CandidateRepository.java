package com.am.jsa.candidate.repository;

import com.am.jsa.candidate.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	@Query("FROM Candidate where id=?1")
	Candidate read(Long id);

	@Query("FROM Candidate entity where entity.user.id = :userId")
	Candidate getCandidateByUserId(@Param("userId") Integer userId);

	@Query("SELECT count(entity) FROM Job entity")
	Long getCandidateCount();
//
//	public List<Job> getAppliedJobs(int candidateId) {
//		String sql="SELECT entity FROM Job entity join entity.candidateApplicationSetId cas where cas = :candidateId";
//		Query query = super.em.createQuery(sql);
//		query.setParameter("candidateId", candidateId);
//		return (List<Job>) query.getResultList();
//	}
//
//	@Query("SELECT count(entity) FROM Job entity")
//	public Long getAppliedJobsCount(int candidateId) {
//		String sql="SELECT count(entity) FROM Job entity join entity.candidateApplicationSetId cas where cas = :candidateId";
//		Query query = super.em.createQuery(sql);
//		query.setParameter("candidateId", candidateId);
//		return (Long)query.getSingleResult();
//	}
//
//	public List<Company> getFollowedCompany(int candidateId) {
//		String sql="SELECT entity FROM Company entity join entity.candidateFollowSet cfs where cfs.id = :candidateId";
//		Query query = super.em.createQuery(sql);
//		query.setParameter("candidateId", candidateId);
//		return (List<Company>) query.getResultList();
//	}
//
//	public Long getFollowedCompanyCount(int candidateId) {
//		String sql="SELECT count(entity) FROM Company entity join entity.candidateFollowSet cfs where cfs.id = :candidateId";
//		Query query = super.em.createQuery(sql);
//		query.setParameter("candidateId", candidateId);
//		return (Long)query.getSingleResult();
//	}

	

}
