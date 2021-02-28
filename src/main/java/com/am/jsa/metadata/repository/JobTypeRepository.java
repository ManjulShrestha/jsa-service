package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType, Long> {

    @Query("FROM JobType WHERE id = ?1")
    JobType read(long id);
}
