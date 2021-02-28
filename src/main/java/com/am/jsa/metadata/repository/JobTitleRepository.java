package com.am.jsa.metadata.repository;
import com.am.jsa.metadata.entity.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface JobTitleRepository extends JpaRepository<JobTitle, Long> {

    @Query("FROM JobTitle WHERE id = ?1")
    JobTitle read(long id);
}
