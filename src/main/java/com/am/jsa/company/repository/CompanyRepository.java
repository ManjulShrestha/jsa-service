package com.am.jsa.company.repository;


import com.am.jsa.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("from Company where id= :id")
	Company read(@Param("id") Long id);

	@Query("Select entity FROM Company entity where entity.user.id = :userId")
	Company getCompanyByUserId(@Param("userId") Long userId) ;

	@Query("Select count(entity) FROM Company entity")
	Long getCompanyCount() ;


	@Query("SELECT entity FROM Company entity join entity.candidateFollowSet cfs where cfs.id = :candidateId")
	public List<Company> getFollowedCompany(@Param("candidateId") Long candidateId) ;

	@Query("SELECT count(entity) FROM Company entity join entity.candidateFollowSet cfs where cfs.id = :candidateId")
	public Long getFollowedCompanyCount(@Param("candidateId") Long candidateId) ;


//	@Query("Select entity. from JOB entity where id= :jobId")
//	public Company getCompanyByJobId(Integer jobId) {
//		String sql = "Select company_id from JOB where id= :jobId";
//		Query query = em.createNativeQuery(sql);
//		query.setParameter("jobId", jobId);
//		Integer companyId= (Integer) query.getSingleResult();
//		return this.read(companyId);
//	}


	

}
