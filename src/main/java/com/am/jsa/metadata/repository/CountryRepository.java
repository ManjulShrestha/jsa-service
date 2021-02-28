package com.am.jsa.metadata.repository;

import com.am.jsa.metadata.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("FROM Country WHERE id = ?1")
    Country read(long id);
}
