package com.am.jsa.metadata.repository;

import com.am.jsa.identity.entity.User;
import com.am.jsa.metadata.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("FROM City WHERE id = ?1")
    City read(long id);
}
