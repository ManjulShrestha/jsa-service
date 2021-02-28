package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.EducationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationTypeRepository extends JpaRepository<EducationType, Long> {

    @Query("FROM EducationType WHERE id = ?1")
    EducationType read(long id);
}
