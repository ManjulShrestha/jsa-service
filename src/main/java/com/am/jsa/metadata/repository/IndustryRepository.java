package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IndustryRepository extends JpaRepository<Industry, Long> {
    @Query("FROM Industry WHERE id = ?1")
    Industry read(long id);
}
