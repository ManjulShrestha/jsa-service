package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.CareerLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerLevelRepository extends JpaRepository<CareerLevel, Long> {
    @Query("FROM CareerLevel WHERE id = ?1")
    CareerLevel read(long id);
}
