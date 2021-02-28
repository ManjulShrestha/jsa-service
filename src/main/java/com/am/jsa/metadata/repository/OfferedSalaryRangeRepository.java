package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.OfferedSalaryRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferedSalaryRangeRepository extends JpaRepository<OfferedSalaryRange, Long> {
    @Query("FROM OfferedSalaryRange WHERE id = ?1")
    OfferedSalaryRange read(long id);
}
