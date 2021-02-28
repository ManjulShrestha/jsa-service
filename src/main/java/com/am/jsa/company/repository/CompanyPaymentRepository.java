package com.am.jsa.company.repository;


import com.am.jsa.company.entity.CompanyPayments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyPaymentRepository extends JpaRepository<CompanyPayments, Long> {


	@Query("SELECT entity FROM CompanyPayments entity where entity.company.id= :companyId")
	List<CompanyPayments> getCompanyPaymentsByCompanyId(@Param("companyId") Long companyid) ;

	@Query("SELECT entity FROM CompanyPayments entity where entity.company.id= :companyId ORDER BY entity.id DESC")
	CompanyPayments getLatestCompanyPaymentsByCompanyId(@Param("companyId") Long companyid) ;


	@Query("from CompanyPayments where id= :id")
	CompanyPayments read(@Param("id") Long id);


	

}
