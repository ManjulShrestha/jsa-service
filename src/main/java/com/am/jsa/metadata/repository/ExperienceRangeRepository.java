package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.ExperienceRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRangeRepository extends JpaRepository<ExperienceRange, Long> {


    @Query("FROM ExperienceRange WHERE id = ?1")
    ExperienceRange read(long id);

}
