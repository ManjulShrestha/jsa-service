package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.AgeRange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AgeRangeRepository extends JpaRepository<AgeRange, Long> {
    @Query("FROM AgeRange WHERE id = ?1")
    AgeRange read(long id);
}
